package aa;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5, 7, 6, 1, 3, 2, 4);
        System.out.println(findNextLargest(input, 0));
    }

    /**
     *
     *  5, 7, 6, 1, 3, 2, 4
     *        7  3  4  4 -1
     *  5,7 7  6,7   1,3,4   3,4   2,4  4,5,7
     *
     *
     *
     * @param input
     * @return
     */
    private static List<Integer> findNextLargest(List<Integer> input, int startIndex) {
        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        int s = input.size();// startIndex - 1

        for (int i=s-1; i>=0; i--) {

            int current = input.get(i);
            while ( !stack.isEmpty() && current > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(current);
        }

        Collections.reverse(result);
        return result;
    }
}
