package queue.Oct5.Oct8;

import java.util.Stack;

public class QFromStack {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();
    private boolean popper = true; // True means First, false means second
    private int size = 0;
    private int capacity = 0;
    QFromStack(int capacity) {

    }

    public void add(int input) {
        pushStack.push(input);
        size++;
    }

    // Making pop costly.
    public int remove() {
        int toRemove = -1;
        if (popper) {
            while (pushStack.isEmpty()) {
               secondStack.push(pushStack.pop());
            }
            toRemove = secondStack.pop();
            popper = !popper;
        } else {
            toRemove = secondStack.pop();
            if (secondStack.isEmpty()) {
                popper = !popper;
            }
        }
        return toRemove;
    }
}

class UseQFromStack {
    public static void main(String[] args) {
        QFromStack q = new QFromStack(4);
        q.add(1);
        q.add(2);
    }
}
