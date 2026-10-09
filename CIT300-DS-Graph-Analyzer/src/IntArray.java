import java.util.Arrays;
import java.util.Random;

/** Resizable integer array with insert, delete, search and display. */
public class IntArray {
    private int[] data;
    private int size;
    private long lastSteps; // elements shifted by the last insert/delete

    public IntArray(int initialCapacity) {
        data = new int[Math.max(1, initialCapacity)];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public long getLastSteps() { return lastSteps; }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    /** Appends at the end - O(1) amortised. */
    public void append(int value) {
        insertAt(size, value);
    }

    /** Inserts at a position (0..size), shifting elements right - O(n). */
    public void insertAt(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Position must be between 0 and " + size);
        if (size == data.length) data = Arrays.copyOf(data, data.length * 2);
        lastSteps = size - index;
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    /** Deletes the element at a position, shifting left - O(n). Returns the removed value. */
    public int deleteAt(int index) {
        if (isEmpty()) throw new IllegalStateException("Array is empty. Nothing to delete.");
        checkIndex(index);
        int removed = data[index];
        lastSteps = size - index - 1;
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removed;
    }

    /** Deletes the first occurrence of a value. Returns false if not found. */
    public boolean deleteValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                deleteAt(i);
                return true;
            }
        }
        return false;
    }

    public void sort() { Arrays.sort(data, 0, size); }

    public boolean isSorted() {
        for (int i = 1; i < size; i++) if (data[i - 1] > data[i]) return false;
        return true;
    }

    /** Replaces the contents with 'count' random numbers in [0, bound). */
    public void fillRandom(int count, int bound) {
        data = new int[Math.max(1, count)];
        size = 0;
        Random r = new Random();
        for (int i = 0; i < count; i++) data[size++] = r.nextInt(bound);
    }

    /** Returns a copy containing only the used part. */
    public int[] toArray() { return Arrays.copyOf(data, size); }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        System.out.println(sb.append("]  (size = ").append(size).append(")"));
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Position must be between 0 and " + (size - 1));
    }
}
