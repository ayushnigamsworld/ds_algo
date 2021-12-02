package easy;

import java.util.Arrays;

public class ClimbingStairs {

    int[] dp;
    public static void main(String[] args) {
        int n = 3;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        climbingStairs.dp = new int[n+1];
        Arrays.fill(climbingStairs.dp, -1);
        System.out.println(climbingStairs.stairs(n));
    }

    public int stairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = stairs(n-1) + stairs(n-2);
        return dp[n];
    }
}
