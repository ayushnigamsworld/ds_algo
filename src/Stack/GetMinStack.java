package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMinStack {
    private int top = -1;
    private int min = Integer.MAX_VALUE;
    private List<Integer> list = new ArrayList<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int a) {
        top++;
        list.add(a);
        if (a < min) {
            minStack.push(a);
            min = a;
        }
    }

    public int pop() {
        if (top == -1) {
            throw new Error("underflow");
        }
        int remove = list.get(top);
        top--;
        if (min == remove) {
            minStack.pop();
            min = minStack.peek();
        }
        return remove;
    }

    public int getMin() {
        return min;
    }
}

class TestMinStack {
    public static void main(String[] args) {
        GetMinStack minStack = new GetMinStack();
        minStack.push(5);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(0);
        minStack.push(4);
        minStack.push(1);
        minStack.push(6);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
