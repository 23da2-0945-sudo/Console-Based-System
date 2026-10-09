/** Linear and binary search that also report steps (comparisons) and time. */
public class SearchAlgorithms {

    /** Holds the outcome of one search. */
    public static class Result {
        public final int index;   // -1 if not found
        public final long steps;  // number of comparisons
        public final long nanos;  // execution time

        Result(int index, long steps, long nanos) {
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    /** O(n) - checks every element in order. Works on unsorted data. */
    public static Result linearSearch(int[] a, int target) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == target) { found = i; break; }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    /** O(log n) - halves the range each step. REQUIRES a sorted array. */
    public static Result binarySearch(int[] a, int target) {
        long start = System.nanoTime();
        long steps = 0;
        int low = 0, high = a.length - 1, found = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            steps++;
            if (a[mid] == target) { found = mid; break; }
            else if (a[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return new Result(found, steps, System.nanoTime() - start);
    }
}
