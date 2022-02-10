package medium.arraysAndStrings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String sr = "bba";
        System.out.println(palindromicSubstring(sr));
    }

    private static String palindromicSubstring(String str) {
        int size = str.length();
        boolean[][] dp = new boolean[size][size];

        // 1 character length will be palindrome O(n)
        for (int start = 0; start < size; start ++) {
            dp[start][start] = true;
        }

        // 2 character length check for palindrome O(n)
        for (int start=0; start<size-1; start++) {
            if (str.charAt(start) == str.charAt(start+1)) {
                dp[start][start+1] = true;
            }
        }

        int maxLength = 1;
        int maxStart = 0;
        int maxEnd = 0;

        // Now from 3 character length to size, palindrome checked in O(1) time.
        for (int len=2; len<=size; len++) {
            for (int start=0; start < size - len + 1; start++) {
                int end = start + len - 1;
                if (str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = dp[start+1][end-1];
                    if (dp[start][end] && (end - start + 1) > maxLength) {
                         maxLength = end - start + 1;
                         maxStart = start;
                         maxEnd = end;
                    }
                } else {
                    dp[start][end] = false;
                }
            }
        }
        if (maxLength > 1) {
            return str.substring(maxStart, maxEnd+1);
        }
        return str.substring(0, 0);
    }
}
