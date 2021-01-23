package stack;

import java.util.Stack;

public class VonageABeforeB {

    public static void main(String[] args) {

    }

    private static boolean aBeforeB(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty() || stack.peek() == 'a') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == 'b' && current == 'b') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == 'b' && current == 'a') {
                return false;
            }
        }
        return true;
    }
}
