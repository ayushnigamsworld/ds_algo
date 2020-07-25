package Stack;

import java.util.Stack;

public class IntroStack {

    public static void main(String[] args) {
        iAmStack();
    }

    private static void iAmStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.search(1);
        stack.peek();
        // stack.empty();
        for (Integer a: stack) {
            System.out.println(a);
        }
        System.out.println(stack.size());
    }
}
