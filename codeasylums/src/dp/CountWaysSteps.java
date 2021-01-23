package dp;

public class CountWaysSteps {

    private static int total;
    private static int[] dp;
    public static void main(String[] args) {
        total = 4;
        dp = new int[total+1];
        for (int i=0; i<=total; i++) {
            dp[i] = -1;
        }
        System.out.println(countWays(total));
    }

    private static int countWays(int remaining) {

        if (remaining < 0) {
            return 0;
        }
        if (remaining == 0) {
            return 1;
        }
        if (dp[remaining] != -1) {
            return dp[remaining];
        }
        int ans = countWays(remaining - 1) + countWays(remaining - 2) +
                countWays(remaining - 3);
        dp[remaining] = ans;
        return ans;
    }
}
