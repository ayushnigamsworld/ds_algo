package Stack;

import java.util.Stack;

public class PreviousGreater {

    public static void main(String[] args) {
        int res[] = previousGreater(new int[] {15, 10, 18, 12, 4, 6, 2, 8});
        for (int r: res) {
            System.out.print(r + " ");
        }
    }

    public static int[] previousGreater(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        res[0] = -1;
        stack.push(arr[0]);

        for (int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int stackTop = stack.peek();
            if (curr < stackTop) {
                res[i] = stackTop;
            } else {
                while (!stack.isEmpty() && stack.peek() < curr) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(curr);
        }
        return res;
    }
}
