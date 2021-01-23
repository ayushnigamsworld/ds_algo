package stack;

import java.util.Stack;

public class Sort01Stable {

    public static void main(String[] args) {

    }

    private static void sortStable(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int a: arr) {
            if (a == 0) {
                stack.push(0);
            }
        }
        int sizeStack = stack.size();
        int noOf1 = arr.length - sizeStack;
        for (int i=0; i<sizeStack; i++) {
            arr[i] = 0;
        }
        for (int i=0; i<noOf1; i++) {
            arr[i] = 1;
        }
    }
}
