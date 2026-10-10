/** Singly linked list of integers. */
public class SinglyLinkedList {

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;
    private long lastSteps; // nodes visited by the last operation

    public int size() { return size; }
    public boolean isEmpty() { return head == null; }
    public long getLastSteps() { return lastSteps; }

    /** O(1) */
    public void insertAtHead(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
        lastSteps = 1;
    }

    /** O(n) - must walk to the last node. */
    public void insertAtTail(int value) {
        Node n = new Node(value);
        lastSteps = 0;
        if (head == null) {
            head = n;
        } else {
            Node cur = head;
            lastSteps++;
            while (cur.next != null) { cur = cur.next; lastSteps++; }
            cur.next = n;
        }
        size++;
    }

    /** Insert at position 0..size. */
    public void insertAt(int position, int value) {
        if (position < 0 || position > size)
            throw new IndexOutOfBoundsException("Position must be between 0 and " + size);
        if (position == 0) { insertAtHead(value); return; }
        Node cur = head;
        lastSteps = 1;
        for (int i = 0; i < position - 1; i++) { cur = cur.next; lastSteps++; }
        Node n = new Node(value);
        n.next = cur.next;
        cur.next = n;
        size++;
    }

    /** Deletes the first node holding the value. Returns false if not found. */
    public boolean deleteByValue(int value) {
        if (isEmpty()) throw new IllegalStateException("List is empty. Nothing to delete.");
        lastSteps = 1;
        if (head.data == value) { head = head.next; size--; return true; }
        Node cur = head;
        while (cur.next != null) {
            lastSteps++;
            if (cur.next.data == value) { cur.next = cur.next.next; size--; return true; }
            cur = cur.next;
        }
        return false;
    }

    /** Deletes the first node. Returns its value. */
    public int deleteAtHead() {
        if (isEmpty()) throw new IllegalStateException("List is empty. Nothing to delete.");
        int v = head.data;
        head = head.next;
        size--;
        lastSteps = 1;
        return v;
    }

    /** Returns the 0-based position of a value or -1. */
    public int search(int value) {
        lastSteps = 0;
        Node cur = head;
        int pos = 0;
        while (cur != null) {
            lastSteps++;
            if (cur.data == value) return pos;
            cur = cur.next;
            pos++;
        }
        return -1;
    }

    public void reverse() {
        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public void display() {
        if (isEmpty()) { System.out.println("  List is empty."); return; }
        StringBuilder sb = new StringBuilder("  HEAD -> ");
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        System.out.println(sb.append("NULL  (size = ").append(size).append(")"));
    }
}
