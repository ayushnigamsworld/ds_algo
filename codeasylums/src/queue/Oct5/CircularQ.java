package queue.Oct5;

import java.util.List;

/**
 * Front and rear can go round-about.
 */
public class CircularQ {
    private Integer[] storage = null;
    private int front = -1;
    private int rear = -1;
    private int size = 0;
    private int capacity = 0;

    CircularQ(int capacity) {
        storage = new Integer[capacity];
        this.capacity = capacity;
    }

    public void add(int input) {
        if (isFull()) {
            throw new Error("Full");
        }
        if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        storage[rear] = input;
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new Error("Empty");
        }
        int toRemove = storage[front];
        if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return toRemove;
    }

    private boolean isFull() {
         return size == capacity;
        //return (rear == capacity-1 && front == 0) || (front - rear == 1);
    }

    private boolean isEmpty() {
         return size == 0;
        //        return front == rear;
    }
}
