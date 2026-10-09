/** Console submenu for queue operations. */
public class QueueMenu {
    public static void run(ArrayQueue queue) {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        queue.enqueue(InputHelper.readInt("Value to enqueue: "));
                        System.out.println("  Enqueued.");
                        break;
                    case 2:
                        System.out.println("  Dequeued: " + queue.dequeue());
                        break;
                    case 3:
                        System.out.println("  Front element: " + queue.peek());
                        break;
                    case 4:
                        queue.display();
                        break;
                    case 5:
                        return;
                }
            } catch (IllegalStateException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }
}
