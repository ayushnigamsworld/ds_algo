public class LongestCommonSubstring {

    public static void main(String[] args) {

    }

    private static int longestCommonSubstring(String str1, String str2, int m, int n, int count) {
        if (m == 0 || n == 0) {
            return count;
        }

        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            count = longestCommonSubstring(str1, str2, m-1, n-1, count + 1);
        }
        count = Math.max(count,
                Math.max(
                        longestCommonSubstring(str1, str2, m-1, n, 0),
                        longestCommonSubstring(str1, str2, m , n-1, 0)));
        return count;
    }
}
