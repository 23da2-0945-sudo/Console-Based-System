import java.util.*;

/** Undirected, unweighted graph stored as an adjacency list. */
public class Graph {

    /** Result of a traversal: visit order, steps and time. */
    public static class TraversalResult {
        public final List<String> order;
        public final long steps;  // vertices visited + edges examined
        public final long nanos;

        TraversalResult(List<String> order, long steps, long nanos) {
            this.order = order;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    private final Map<String, List<String>> adjacency = new LinkedHashMap<>();
    private long lastSearchSteps;

    public boolean isEmpty() { return adjacency.isEmpty(); }
    public int vertexCount() { return adjacency.size(); }
    public boolean hasVertex(String v) { return adjacency.containsKey(v); }
    public long getLastSearchSteps() { return lastSearchSteps; }

    public int edgeCount() {
        int total = 0;
        for (List<String> n : adjacency.values()) total += n.size();
        return total / 2;
    }

    public String firstVertex() {
        if (isEmpty()) throw new IllegalStateException("The graph is empty.");
        return adjacency.keySet().iterator().next();
    }

    /** Returns false if the vertex already exists. */
    public boolean addVertex(String v) {
        if (adjacency.containsKey(v)) return false;
        adjacency.put(v, new ArrayList<>());
        return true;
    }

    /** Returns false if the edge already exists. Throws if a vertex is missing or both are the same. */
    public boolean addEdge(String a, String b) {
        if (!hasVertex(a) || !hasVertex(b))
            throw new IllegalArgumentException("Both vertices must exist. Add them first.");
        if (a.equals(b)) throw new IllegalArgumentException("Self-loops are not allowed.");
        if (adjacency.get(a).contains(b)) return false;
        adjacency.get(a).add(b);
        adjacency.get(b).add(a);
        return true;
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Graph is empty."); return; }
        System.out.println("  Adjacency list (" + vertexCount() + " vertices, " + edgeCount() + " edges):");
        for (Map.Entry<String, List<String>> e : adjacency.entrySet()) {
            System.out.println("    " + e.getKey() + " -> " + (e.getValue().isEmpty() ? "(no neighbours)" : String.join(", ", e.getValue())));
        }
    }

    /** Breadth-first traversal using a queue. O(V + E) */
    public TraversalResult bfs(String start) {
        requireVertex(start);
        long t0 = System.nanoTime();
        long steps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            order.add(cur);
            steps++;                                  // vertex visited
            for (String nb : adjacency.get(cur)) {
                steps++;                              // edge examined
                if (visited.add(nb)) queue.add(nb);
            }
        }
        return new TraversalResult(order, steps, System.nanoTime() - t0);
    }

    /** Depth-first traversal using an explicit stack. O(V + E) */
    public TraversalResult dfs(String start) {
        requireVertex(start);
        long t0 = System.nanoTime();
        long steps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (!visited.add(cur)) continue;
            order.add(cur);
            steps++;                                  // vertex visited
            List<String> nbs = adjacency.get(cur);
            // push in reverse so neighbours are visited in insertion order
            for (int i = nbs.size() - 1; i >= 0; i--) {
                steps++;                              // edge examined
                if (!visited.contains(nbs.get(i))) stack.push(nbs.get(i));
            }
        }
        return new TraversalResult(order, steps, System.nanoTime() - t0);
    }

    /** Shortest path (fewest edges) using BFS. Empty list if no path exists. */
    public List<String> shortestPath(String from, String to) {
        requireVertex(from);
        requireVertex(to);
        lastSearchSteps = 0;
        Map<String, String> parent = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        parent.put(from, null);
        queue.add(from);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            lastSearchSteps++;
            if (cur.equals(to)) break;
            for (String nb : adjacency.get(cur)) {
                lastSearchSteps++;
                if (!parent.containsKey(nb)) { parent.put(nb, cur); queue.add(nb); }
            }
        }
        LinkedList<String> path = new LinkedList<>();
        if (!parent.containsKey(to)) return path;
        for (String at = to; at != null; at = parent.get(at)) path.addFirst(at);
        return path;
    }

    /** Loads a small demo graph. */
    public void loadSample() {
        adjacency.clear();
        for (String v : new String[]{"A", "B", "C", "D", "E", "F", "G"}) addVertex(v);
        String[][] edges = {{"A","B"},{"A","C"},{"B","D"},{"B","E"},{"C","F"},{"E","F"},{"F","G"}};
        for (String[] e : edges) addEdge(e[0], e[1]);
    }

    private void requireVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException("Vertex '" + v + "' does not exist.");
    }
}
