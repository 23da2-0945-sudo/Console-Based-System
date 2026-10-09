/** Console submenu for array operations. */
public class ArrayMenu {
    public static void run(IntArray array) {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at end");
            System.out.println("2. Insert at position");
            System.out.println("3. Delete by position");
            System.out.println("4. Delete by value");
            System.out.println("5. Search for a value");
            System.out.println("6. Sort array");
            System.out.println("7. Fill with random numbers");
            System.out.println("8. Display array");
            System.out.println("9. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);
            try {
                switch (choice) {
                    case 1:
                        array.append(InputHelper.readInt("Value to insert: "));
                        System.out.println("  Inserted.");
                        break;
                    case 2:
                        int pos = InputHelper.readInt("Position (0-" + array.size() + "): ");
                        array.insertAt(pos, InputHelper.readInt("Value to insert: "));
                        System.out.println("  Inserted. Elements shifted: " + array.getLastSteps());
                        break;
                    case 3:
                        int removed = array.deleteAt(InputHelper.readInt("Position to delete: "));
                        System.out.println("  Deleted value " + removed + ". Elements shifted: " + array.getLastSteps());
                        break;
                    case 4:
                        int v = InputHelper.readInt("Value to delete: ");
                        System.out.println(array.deleteValue(v) ? "  Deleted." : "  Value " + v + " not found.");
                        break;
                    case 5:
                        if (array.isEmpty()) { System.out.println("  Array is empty."); break; }
                        int t = InputHelper.readInt("Value to search: ");
                        SearchAlgorithms.Result r = SearchAlgorithms.linearSearch(array.toArray(), t);
                        System.out.println(r.index >= 0
                                ? "  Found at position " + r.index + " (steps: " + r.steps + ")"
                                : "  Not found (steps: " + r.steps + ")");
                        break;
                    case 6:
                        array.sort();
                        System.out.println("  Array sorted.");
                        break;
                    case 7:
                        int n = InputHelper.readIntInRange("How many numbers (1-100000): ", 1, 100000);
                        array.fillRandom(n, 1000);
                        System.out.println("  Array filled with " + n + " random numbers (0-999).");
                        break;
                    case 8:
                        array.display();
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
