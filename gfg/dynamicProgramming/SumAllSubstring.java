package dynamicProgramming;

public class SumAllSubstring {

    public static void main(String[] args) {
        int res = substr("1234", "", 3, 0);
        System.out.println(res);
    }

    private static int substr(String s, String sub, int n, int sum) {
        if (n < 0) {
            return sum + toInteger(sub);
        }
        int sum1 = substr(s, sub + s.charAt(n), n-1, sum + toInteger(sub));
        int sum2 = substr(s, sub, n-1, sum + toInteger(sub));
        return sum1 + sum2;
    }

    private static int toInteger(String sub) {
        return sub.equals("") ? 0 : Integer.parseInt(reverse(sub));
    }

    private static String reverse(String str) {
        StringBuilder input1 = new StringBuilder(str);
        return input1.reverse().toString();
    }
}
