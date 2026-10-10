/** Performance / complexity comparison of searching, insertion and graph traversal. */
public class PerformanceAnalyzer {

    public static void run(Graph graph) {
        int n = InputHelper.readIntInRange("Data size n for the test (10-20000): ", 10, 20000);

        // Build a sorted array 0..n-1 so both searches are valid.
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = i;
        int worstTarget = n - 1;   // last element: worst case for linear search
        int absentTarget = -1;     // not present: worst case for both

        SearchAlgorithms.Result lin1 = SearchAlgorithms.linearSearch(sorted, worstTarget);
        SearchAlgorithms.Result bin1 = SearchAlgorithms.binarySearch(sorted, worstTarget);
        SearchAlgorithms.Result lin2 = SearchAlgorithms.linearSearch(sorted, absentTarget);
        SearchAlgorithms.Result bin2 = SearchAlgorithms.binarySearch(sorted, absentTarget);

        // Insert n values at the FRONT: array (shifts) vs linked list (head insert).
        IntArray arr = new IntArray(10);
        long arrayStart = System.nanoTime();
        long arraySteps = 0;
        for (int i = 0; i < n; i++) { arr.insertAt(0, i); arraySteps += arr.getLastSteps(); }
        long arrayNanos = System.nanoTime() - arrayStart;

        SinglyLinkedList list = new SinglyLinkedList();
        long listStart = System.nanoTime();
        long listSteps = 0;
        for (int i = 0; i < n; i++) { list.insertAtHead(i); listSteps += list.getLastSteps(); }
        long listNanos = System.nanoTime() - listStart;

        // Graph traversals
        if (graph.isEmpty()) {
            System.out.println("\n(The graph is empty - loading the sample graph for the comparison.)");
            graph.loadSample();
        }
        String start = graph.firstVertex();
        Graph.TraversalResult bfs = graph.bfs(start);
        Graph.TraversalResult dfs = graph.dfs(start);

        String line = "-------------------------------------------------------------------------------";
        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON  (n = " + n + ")");
        System.out.println("=============================================");
        System.out.printf("%-18s %-30s %10s %12s  %s%n", "Operation", "Algorithm / Case", "Steps", "Time (ns)", "Complexity");
        System.out.println(line);
        row("Search", "Linear Search (last item)", lin1.steps, lin1.nanos, "O(n)");
        row("Search", "Binary Search (last item)", bin1.steps, bin1.nanos, "O(log n)");
        row("Search", "Linear Search (absent)", lin2.steps, lin2.nanos, "O(n)");
        row("Search", "Binary Search (absent)", bin2.steps, bin2.nanos, "O(log n)");
        row("Insert n at front", "Array (shift elements)", arraySteps, arrayNanos, "O(n) each");
        row("Insert n at front", "Linked List (head insert)", listSteps, listNanos, "O(1) each");
        row("Graph Traversal", "BFS from '" + start + "'", bfs.steps, bfs.nanos, "O(V + E)");
        row("Graph Traversal", "DFS from '" + start + "'", dfs.steps, dfs.nanos, "O(V + E)");
        System.out.println(line);
        System.out.println("Graph: " + graph.vertexCount() + " vertices, " + graph.edgeCount() + " edges.");
        System.out.println("Why they differ: linear search checks items one by one (O(n)), binary search halves");
        System.out.println("the range each step (O(log n)). Array front-insert shifts every element (O(n)) while a");
        System.out.println("linked list only changes the head pointer (O(1)). BFS and DFS both visit every vertex and");
        System.out.println("edge once, so they cost O(V + E) - only the visiting ORDER differs.");
        System.out.println("(Times vary between runs - step counts are the reliable measure.)");

        ResultLog.add("Performance (n=" + n + "): Linear(last)=" + lin1.steps + " steps, Binary(last)=" + bin1.steps
                + " steps; Array front-insert=" + arraySteps + " steps, LinkedList front-insert=" + listSteps
                + " steps; BFS=" + bfs.steps + " steps, DFS=" + dfs.steps + " steps");
    }

    private static void row(String op, String algo, long steps, long nanos, String complexity) {
        System.out.printf("%-18s %-30s %10d %12d  %s%n", op, algo, steps, nanos, complexity);
    }
}
