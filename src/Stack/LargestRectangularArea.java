package Stack;

import java.util.Stack;

public class LargestRectangularArea {

    public static void main(String[] args) {
        System.out.print(optimizedLargestRectArea(new int[]{6, 2, 5, 4, 1, 5, 6}));
    }

    private static int largestRectangularArea(int[] inp) {
        int res = -1;
        int i = 0;
        while (i < inp.length) {
            int localRes = inp[i];
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && inp[l] > inp[i]) {
                localRes += inp[i];
                l--;
            }
            while (r < inp.length && inp[r] > inp[i]) {
                localRes += inp[i];
                r++;
            }
            res = Math.max(res, localRes);
            i++;
        }
        return res;
    }

    private static int optimizedLargestRectArea(int[] inp) {
        Stack<Integer> stack = new Stack<>();
        int n = inp.length;
        int res = -1;
        for (int i = 0; i < inp.length; i++) {
            while (!stack.isEmpty() && inp[stack.peek()] >= inp[i]) {
                int top = stack.pop();
                int localLeft = inp[top] * (stack.isEmpty() ? i : (i - top));  // Left calculation.
                res = Math.max(res, localLeft);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int localRight = inp[top] * (stack.isEmpty() ? n : (n - top));  // Right calculation.
            res = Math.max(res, localRight);
        }
        return res;
    }
}
