package medium.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePaths {

    int res = 0;
    int[][] dp;
    int cached = 0;
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        UniquePaths uniquePaths = new UniquePaths();
        List<String> path = new ArrayList<>();
        uniquePaths.dp = new int[m][n];
        for (int i=0; i<m; i++) {
            Arrays.fill(uniquePaths.dp[i], -1);
        }
        int r = uniquePaths.uniquePathsMemoization(0, 0, m-1, n-1);
//        int r = uniquePaths.uniquePathsTabulation(m, n);
        System.out.println(r);
    }

    private int uniquePathsMemoization(int row, int col, int m, int n) {

        if (row > m || col > n) {
            return 0;
        }

        if (dp[row][col] != -1) {
            this.cached++;
            return dp[row][col];
        }

        if (row == m && col == n) {
            return 1;
        }

        int l = uniquePathsMemoization(row + 1, col, m, n);
        int r = uniquePathsMemoization(row, col + 1, m, n);
        dp[row][col] = l + r;
        return l + r;
    }

    private int uniquePathsTabulation(int m, int n) {
        dp[0][0] = -1;
        for (int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            dp[0][j] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
