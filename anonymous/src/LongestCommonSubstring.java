import java.util.Arrays;

public class LongestCommonSubstring {

    private static int[][] dp;
    public static void main(String[] args) {
        String str1 = "aacabdkacaa";
        String str2 = new StringBuilder(str1).reverse().toString();
        int m = str1.length();
        int n = str2.length();
        dp = new int[m+1][n+1];
        int result = longestCommonSubstring(str1, str2, str1.length(), str2.length());
        System.out.println(result);
    }

    private static int longestCommonSubstring(String str1, String str2, int m, int n) {
        int result = 0;
        int finalIndexI = 0;
        int finalIndexJ = 0;
        for (int i=-1; i<n; i++) {
            if (i >=0) {
                System.out.print(str2.charAt(i) + " ");
            } else {
                System.out.print("  ");
            }
        }
        for (int i=0; i<=m; i++) {
            if (i != 0) {
                System.out.print(str1.charAt(i-1) + " ");
            }
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if (dp[i][j] > result) {
                        finalIndexI = i;
                        finalIndexJ = j;
                    }
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        String resultString = "";
        while (finalIndexI >=0 && finalIndexJ >=0 && dp[finalIndexI][finalIndexJ] != 0) {
            resultString += str1.charAt(finalIndexI-1);
            finalIndexI--;
            finalIndexJ--;
        }
        System.out.println(resultString);
        return result;
    }
}
