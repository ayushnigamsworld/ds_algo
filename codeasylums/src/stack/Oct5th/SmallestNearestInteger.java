package stack.Oct5th;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallestNearestInteger {

    public static void main(String[] args) {

    }

    private static void findNearestSmallestForEach(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int current: arr) {
            if (stack.size() == 0) {
                stack.push(current);
                result.add(-1);
                continue;
            }
            if (current > stack.peek()) {
                result.add(stack.peek());
                stack.push(current);

            } else {
                while (!stack.isEmpty() && stack.peek() > current) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
                stack.push(current);
            }
        }
    }
}
