package dp;

import java.util.List;

public class LIS {
    private static int inp[];
    private static int dp[];
    public static void main(String[] args) {
        inp = new int[]{3, 10, 2, 1, 20};
        dp = new int[inp.length];
        for (int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }
        int ans = 0;
        for (int i=0; i<inp.length; i++) {
            ans = Math.max(ans, 1 + LIS(i));
        }
        System.out.println(ans);
    }

    private static int LIS(int index) {
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans = 0;
        for (int i = index+1; i<inp.length; i++) {
            if (inp[index] < inp[i]) {
                ans = Math.max(ans, 1 + LIS(i));
            }
        }
        dp[index] = ans;
        return ans;
    }
}
