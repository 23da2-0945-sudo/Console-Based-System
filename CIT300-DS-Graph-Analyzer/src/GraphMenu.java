import java.util.List;

/** Console submenu for graph operations. */
public class GraphMenu {
    public static void run(Graph graph) {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Find Shortest Path (search)");
            System.out.println("7. Load Sample Graph");
            System.out.println("8. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 8);
            try {
                switch (choice) {
                    case 1:
                        String v = InputHelper.readNonEmpty("Vertex name: ");
                        System.out.println(graph.addVertex(v) ? "  Vertex added." : "  Vertex already exists.");
                        break;
                    case 2:
                        String a = InputHelper.readNonEmpty("From vertex: ");
                        String b = InputHelper.readNonEmpty("To vertex: ");
                        System.out.println(graph.addEdge(a, b) ? "  Edge added." : "  Edge already exists.");
                        break;
                    case 3:
                        graph.display();
                        break;
                    case 4:
                    case 5:
                        if (graph.isEmpty()) { System.out.println("  Graph is empty. Add vertices first."); break; }
                        String start = InputHelper.readNonEmpty("Start vertex: ");
                        boolean isBfs = choice == 4;
                        Graph.TraversalResult r = isBfs ? graph.bfs(start) : graph.dfs(start);
                        String name = isBfs ? "BFS" : "DFS";
                        System.out.println("  " + name + " order: " + String.join(" -> ", r.order));
                        System.out.println("  Steps: " + r.steps + " | Time: " + r.nanos + " ns");
                        ResultLog.add(name + " from " + start + ": " + String.join(" -> ", r.order) + " (steps = " + r.steps + ")");
                        break;
                    case 6:
                        if (graph.isEmpty()) { System.out.println("  Graph is empty. Add vertices first."); break; }
                        String from = InputHelper.readNonEmpty("From vertex: ");
                        String to = InputHelper.readNonEmpty("To vertex: ");
                        List<String> path = graph.shortestPath(from, to);
                        if (path.isEmpty()) {
                            System.out.println("  No path exists between " + from + " and " + to + ".");
                        } else {
                            System.out.println("  Shortest path: " + String.join(" -> ", path) + " (" + (path.size() - 1) + " edges, steps: " + graph.getLastSearchSteps() + ")");
                            ResultLog.add("Shortest path " + from + " to " + to + ": " + String.join(" -> ", path));
                        }
                        break;
                    case 7:
                        graph.loadSample();
                        System.out.println("  Sample graph loaded (A-G).");
                        break;
                    case 8:
                        return;
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }
}
