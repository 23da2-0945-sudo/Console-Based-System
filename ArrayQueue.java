/** Fixed-capacity circular queue (FIFO) implemented with an array. */
public class ArrayQueue {
    private final int[] items;
    private int front = 0;
    private int count = 0;

    public ArrayQueue(int capacity) { items = new int[capacity]; }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == items.length; }
    public int size() { return count; }

    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue overflow - the queue is full (capacity " + items.length + ").");
        items[(front + count) % items.length] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow - cannot dequeue from an empty queue.");
        int value = items[front];
        front = (front + 1) % items.length;
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("The queue is empty - no front element.");
        return items[front];
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Queue is empty."); return; }
        StringBuilder sb = new StringBuilder("  FRONT -> ");
        for (int i = 0; i < count; i++) sb.append(items[(front + i) % items.length]).append(i < count - 1 ? " , " : "");
        System.out.println(sb.append(" <- REAR  (size = ").append(count).append(")"));
    }
}
