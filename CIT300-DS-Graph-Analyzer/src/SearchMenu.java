/** Console submenu for linear vs binary search. */
public class SearchMenu {
    public static void run(IntArray array) {
        while (true) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 4);
            if (choice == 4) return;

            if (array.isEmpty()) {
                System.out.println("  The array is empty. Add data in 'Array Operations' first.");
                continue;
            }
            if (choice != 1 && !array.isSorted()) {
                System.out.println("  Binary search needs a SORTED array. The array is not sorted.");
                if (InputHelper.readIntInRange("  Sort it now? (1 = yes, 2 = no): ", 1, 2) == 1) {
                    array.sort();
                    System.out.println("  Array sorted.");
                } else {
                    continue;
                }
            }
            int[] data = array.toArray();
            int target = InputHelper.readInt("Value to search: ");

            if (choice == 1 || choice == 3) report("Linear Search", SearchAlgorithms.linearSearch(data, target), target);
            if (choice == 2 || choice == 3) report("Binary Search", SearchAlgorithms.binarySearch(data, target), target);
            if (choice == 3) System.out.println("  -> Binary search needs far fewer steps on larger arrays: O(log n) vs O(n).");
        }
    }

    private static void report(String name, SearchAlgorithms.Result r, int target) {
        String outcome = r.index >= 0 ? "found at position " + r.index : "not found";
        System.out.printf("  %-14s: %s | steps = %d | time = %d ns%n", name, outcome, r.steps, r.nanos);
        ResultLog.add(name + " for " + target + ": " + outcome + ", steps = " + r.steps + ", time = " + r.nanos + " ns");
    }
}
