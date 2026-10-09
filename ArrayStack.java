/** Fixed-capacity stack (LIFO) implemented with an array. */
public class ArrayStack {
    private final int[] items;
    private int top = -1;

    public ArrayStack(int capacity) { items = new int[capacity]; }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == items.length - 1; }
    public int size() { return top + 1; }

    public void push(int value) {
        if (isFull()) throw new IllegalStateException("Stack overflow - the stack is full (capacity " + items.length + ").");
        items[++top] = value;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack underflow - cannot pop from an empty stack.");
        return items[top--];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("The stack is empty - nothing to peek.");
        return items[top];
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Stack is empty."); return; }
        System.out.println("  TOP -> ");
        for (int i = top; i >= 0; i--) System.out.println("        | " + items[i] + " |");
        System.out.println("        ---- (size = " + size() + ")");
    }
}
