public class LongestCommonSubs {

    public static void main(String[] args) {
        lcs("", "", 0, 0, "abcdef", "abdgf");
    }

    private static int lcs(String str1, String str2, int i, int j, String orig1, String orig2) {
        if (i == orig1.length() || j == orig2.length()) {
            if (str1.equals(str2)) {
                return str1.length();
            }
            return 0;
        }

        return Math.max(
                lcs(str1, str2, i+1, j+1, orig1, orig2),
                lcs(str1 + orig1.charAt(i), str2 + orig2.charAt(j),  i+1, j+1, orig1, orig2));
    }
}
