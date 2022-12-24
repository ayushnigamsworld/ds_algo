package aa;

import java.util.Arrays;

public class LongestIncreasingSubs {

    public static void main(String[] args) {
        int input1[] = {3, 2, 5, -1, 1, 6, 7, 4};
        int input2[] = {2, 2, 2, 2, 2};
        int input3[] = {0, 1, 2, 0, 1, 2, 3};
        int input4[] = {2, 4, -1, 3, 2, 9};
        System.out.println(lis(input1));
        System.out.println(lis(input2));
        System.out.println(lis(input3));
        System.out.println(lis(input4));
    }

    // {3, 2, 5, -1, 1, 6, 7, 4}
    // [3]       []
    // [3, 2]    []
    // [3, 2, 5] []
    // [3, 2, 5, -4] []
    // [3, 2, 5, -4, -3] []
    // [3, 2, 5, -4, -3, -2] []
    // [3, 2, 5, -4, -3, -2, 6] []
    // [3, 2, 5, -4, -3, -2, -1]
    // [3, 2, 5, -4, -3, -2, -1, 0]
    // Time complexity: O(n ^ 2)
    // Space complexity : O(n)
    private static int lis(int[] input) {
        int result = 1;
        int n = input.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i=0; i<n; i++) {
            int current = input[i];
            int k = 0;
            while (k < i) {
                int toCompare = input[k];
                if (current > toCompare) {
                    dp[i] = Math.max(dp[k] + 1, dp[i]);
                    result = Math.max(result, dp[i]);
                }
                k++;
            }
        }
        return result;
    }
}
