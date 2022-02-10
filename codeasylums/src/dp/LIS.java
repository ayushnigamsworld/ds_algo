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
        int lis[] = new int[n];
        int i, j, max = 0;
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute optimized LIS values in
           bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }
}
