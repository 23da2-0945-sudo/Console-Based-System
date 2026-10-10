/** Entry point: integrates every component into one console application. */
public class Main {
    public static void main(String[] args) {
        // One shared instance of each data structure for the whole session.
        IntArray array = new IntArray(10);
        ArrayStack stack = new ArrayStack(10);
        ArrayQueue queue = new ArrayQueue(10);
        SinglyLinkedList list = new SinglyLinkedList();
        Graph graph = new Graph();

        while (true) {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);
            switch (choice) {
                case 1: ArrayMenu.run(array); break;
                case 2: StackMenu.run(stack); break;
                case 3: QueueMenu.run(queue); break;
                case 4: LinkedListMenu.run(list); break;
                case 5: SearchMenu.run(array); break;
                case 6: GraphMenu.run(graph); break;
                case 7: PerformanceAnalyzer.run(graph); break;
                case 8: ResultLog.displayAll(); break;
                case 9:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
