package dynamicProgramming;

public class CountNotRepeatCombination {
    public static void main(String[] args) {

    }

    public static int countNotRepeatCombination(int n) {
        // given 3 or 5 or 10 points allowed
        int dp[] = new int[n+1];
        dp[0] = 1;
        for (int i=3; i<=n; i++) {
            dp[i] += dp[i-3];
        }
        for (int i=5; i<=n; i++) {
            dp[i] += dp[i-5];
        }
        for (int i=10; i<=n; i++) {
            dp[i] += dp[i-10];
        }
        return dp[n];
    }
}
