package stack;

import java.util.Stack;

public class CheckOrderParanthesis {

    public static void main(String[] args) {
        char[] c = new char[4];
        c[0] = '{';
        c[1] = '}';
        c[2] = '(';
        c[3] = ')';
//        c[4] = '{';
        System.out.println(isCorrectOrder(c));
    }

    /**
     * (((}{}
     * @param input
     * @return
     */
    private static boolean isCorrectOrder(char[] input) {
        Stack stack = new Stack();
        for (Character c: input) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            Character temp = null;
            if (stack.isEmpty()) {
                return false;
            }
            switch (c) {
                case ')':
                    temp = (Character) stack.pop();
                    if (temp != '(') {
                        return false;
                    }
                    break;
                case '}':
                    temp = (Character) stack.pop();
                    if (temp != '{') {
                        return false;
                    }
                    break;
                case ']':
                    temp = (Character) stack.pop();
                    if (temp != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
