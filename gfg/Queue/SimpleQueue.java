package Queue;

public class SimpleQueue {
    private int size, cap;
    private int[] arr;
    private int top = -1, rear = -1;

    SimpleQueue(int capacity) {
        arr = new int[capacity];
        size = 0;
        this.cap = capacity;
    }

    public void enqueue(int a) {
        if (size +1 > cap) {
            // throw new Error("overflow");
            System.out.println("overflow");
            return;
        }
        if (size == 0) {
            top++;
        }
        size++;
        rear = (rear + 1) % cap;
        arr[rear] = a;
    }

    public int dequeue() {
        if (top == -1 || size ==0) {
            //throw new Error("underflow");
            System.out.println("underflow");
            return -1;
        }
        int d = arr[top];
        top = (top + 1) % cap;
        size--;
        return d;
    }

    public int getSize() {
        return size;
    }
}


class UseQueue {
    public static void main(String[] args) {
        SimpleQueue simpleQueue = new SimpleQueue(5);
        System.out.println("Enque 1");
        simpleQueue.enqueue(1);
        System.out.println("Enque 2");
        simpleQueue.enqueue(2);
        System.out.println("Enque 3");
        simpleQueue.enqueue(3);
        System.out.println("Enque 4");
        simpleQueue.enqueue(4);
        System.out.println("Enque 5");
        simpleQueue.enqueue(5);
        System.out.println("Enque 6");
        simpleQueue.enqueue(6);
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Enque 7");
        simpleQueue.enqueue(7);
        System.out.println("Enque 8");
        simpleQueue.enqueue(8);
        System.out.println("Enque 1");
        simpleQueue.enqueue(1);
        System.out.println("Enque 2");
        simpleQueue.enqueue(2);
        System.out.println("Enque 3");
        simpleQueue.enqueue(3);
        System.out.println("Enque 4");
        simpleQueue.enqueue(4);
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
        System.out.println("Deque");
        System.out.println(simpleQueue.dequeue());
    }
}
