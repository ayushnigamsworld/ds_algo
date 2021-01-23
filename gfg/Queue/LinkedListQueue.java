package Queue;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedListQueue {
    private int size = 0;
    private Node top = null;
    private Node rear = null;
    LinkedListQueue() {
    }

    public void enqueue(int a) {
        Node newNode = new Node(a);
        if (rear == null) {
            rear = newNode;
            top = rear;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (top == null) {
            System.out.println("Underflow");
            return -1;
        }
        size --;
        Node toRemove = top;
        top = top.next;
        if (top == null) {
            rear = null;
        }
        toRemove.next = null;
        return toRemove.data;
    }
}

class UseQueueLinkedList {
    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        System.out.println(linkedListQueue.dequeue());
        linkedListQueue.enqueue(4);
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
    }
}
