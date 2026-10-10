/** Console submenu for linked list operations. */
public class LinkedListMenu {
    public static void run(SinglyLinkedList list) {
        while (true) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ---------------");
            System.out.println("1. Insert at head");
            System.out.println("2. Insert at tail");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete by value");
            System.out.println("5. Delete head");
            System.out.println("6. Search for a value");
            System.out.println("7. Reverse list");
            System.out.println("8. Display list");
            System.out.println("9. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);
            try {
                switch (choice) {
                    case 1:
                        list.insertAtHead(InputHelper.readInt("Value to insert: "));
                        System.out.println("  Inserted at head (steps: " + list.getLastSteps() + ").");
                        break;
                    case 2:
                        list.insertAtTail(InputHelper.readInt("Value to insert: "));
                        System.out.println("  Inserted at tail (steps: " + list.getLastSteps() + ").");
                        break;
                    case 3:
                        int pos = InputHelper.readInt("Position (0-" + list.size() + "): ");
                        list.insertAt(pos, InputHelper.readInt("Value to insert: "));
                        System.out.println("  Inserted (steps: " + list.getLastSteps() + ").");
                        break;
                    case 4:
                        int v = InputHelper.readInt("Value to delete: ");
                        System.out.println(list.deleteByValue(v)
                                ? "  Deleted (steps: " + list.getLastSteps() + ")."
                                : "  Value " + v + " not found.");
                        break;
                    case 5:
                        System.out.println("  Deleted head value: " + list.deleteAtHead());
                        break;
                    case 6:
                        if (list.isEmpty()) { System.out.println("  List is empty."); break; }
                        int t = InputHelper.readInt("Value to search: ");
                        int found = list.search(t);
                        String msg = found >= 0 ? "found at position " + found : "not found";
                        System.out.println("  " + t + " " + msg + " (steps: " + list.getLastSteps() + ")");
                        ResultLog.add("Linked List search for " + t + ": " + msg + ", steps = " + list.getLastSteps());
                        break;
                    case 7:
                        list.reverse();
                        System.out.println("  List reversed.");
                        break;
                    case 8:
                        list.display();
                        break;
                    case 9:
                        return;
                }
            } catch (IndexOutOfBoundsException | IllegalStateException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }
}
