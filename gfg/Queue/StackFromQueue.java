package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackFromQueue {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private boolean push = true;
    private int size = 0;

    public void push(int a) {
        if (push) {
            q1.offer(a);
        } else {
            q2.offer(a);
        }
        size++;
    }

    public int pop() {
        size--;
        if (push) {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            push = !push;
            return q1.poll();
        } else {
            while (q2.size() != 1) {
                q1.offer(q2.poll());
            }
            push = !push;
            return q2.poll();
        }
    }
}

class UseStackFromQ {
    public static void main(String[] args) {
        StackFromQueue stackFromQueue = new StackFromQueue();
        stackFromQueue.push(1);
        stackFromQueue.push(2);
        stackFromQueue.push(3);
        System.out.println(stackFromQueue.pop());
        stackFromQueue.push(4);
        System.out.println(stackFromQueue.pop());
        System.out.println(stackFromQueue.pop());
    }
}
