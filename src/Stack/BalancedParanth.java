package Stack;

import java.util.Stack;

public class BalancedParanth {

    public static void main(String[] args) {
        System.out.println(isBalancedParanthesis("[]{{([])}}"));
    }

    public static boolean isBalancedParanthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c== '[') {
                stack.push(c);
            }else {
                if (stack.empty() || isPair(str.charAt(i), stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    private static boolean isPair(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
