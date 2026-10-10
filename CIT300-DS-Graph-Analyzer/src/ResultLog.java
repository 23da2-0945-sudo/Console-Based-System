import java.util.ArrayList;
import java.util.List;

/** Stores a short description of every important result (menu option 8). */
public class ResultLog {
    private static final List<String> RESULTS = new ArrayList<>();

    public static void add(String entry) {
        RESULTS.add(entry);
    }

    public static void displayAll() {
        System.out.println("\n=============================================");
        System.out.println(" ALL RESULTS (this session)");
        System.out.println("=============================================");
        if (RESULTS.isEmpty()) {
            System.out.println("No results recorded yet. Run searches, traversals or the performance comparison first.");
            return;
        }
        for (int i = 0; i < RESULTS.size(); i++) {
            System.out.println((i + 1) + ". " + RESULTS.get(i));
        }
    }
}
