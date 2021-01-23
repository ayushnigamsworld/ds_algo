package dp;

public class MinCostPath {

    private static int mat[][];
    private static int N;
    private static int M;
    private static int dp[][];
    public static void main(String[] args) {
        mat = new int[][]{
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        N = 3;
        M = 3;
        dp = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(minCost(0, 0));
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int minCost(int i, int j) {
        if (i == N || j == M ) {
            return 1000000000;
        }
        if (i == N-1 && j == M-1) {
            return mat[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, mat[i][j] + minCost(i+1, j));
        ans = Math.min(ans, mat[i][j] + minCost(i, j+1));
        ans = Math.min(ans, mat[i][j] + minCost(i+1, j+1));
        dp[i][j] = ans;
        return ans;
    }
}
