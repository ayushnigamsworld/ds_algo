package queue.Oct5;

import linked_list.LinkedList;
import linked_list.Node;

/**
 * Fix this by doing front -> 1 -> 2 -> 3 <- rear
 * rather than 3 -> 2 -> 1
 */
public class MyQueue {

    private linked_list.LinkedList linkedList = null;
    private int size = 0;
    private Node front = null;
    private Node rear = null;

    public MyQueue() {
        linkedList = new LinkedList(-1);
        linkedList.head = rear;
    }

    public void add(int inp) {
        if (rear == null) {
            front = new Node(inp);
            rear = front;
        } else {
            Node temp = new Node(inp);
            temp.next = rear;
            rear = temp;
        }
    }

    public int remove() {
        if (front == null) {
            throw new Error("No element");
        }
        Node temp = rear;
        while (temp.next != front) {
            temp = temp.next;
        }
        int removed = front.data;
        temp.next = null;
        front = temp;
        return removed;
    }

    public Integer seek() {
        if (front == null) {
            return null;
        }
        return front.data;
    }
}
