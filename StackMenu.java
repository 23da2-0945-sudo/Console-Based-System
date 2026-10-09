/** Console submenu for stack operations. */
public class StackMenu {
    public static void run(ArrayStack stack) {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        stack.push(InputHelper.readInt("Value to push: "));
                        System.out.println("  Pushed.");
                        break;
                    case 2:
                        System.out.println("  Popped: " + stack.pop());
                        break;
                    case 3:
                        System.out.println("  Top element: " + stack.peek());
                        break;
                    case 4:
                        stack.display();
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
