import java.util.Scanner;

/** Shared console input helper with validation (used by every menu). */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    /** Reads a whole number; repeats until the input is valid. */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads a whole number between min and max (inclusive). */
    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("  Please enter a number between " + min + " and " + max + ".");
        }
    }

    /** Reads a non-empty text value. */
    public static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("  Input cannot be empty.");
        }
    }
}
