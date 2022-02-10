package Schrodinger;

public class LIS {

    public static void main(String[] args) {

        int[] inp = {1,4,5,2,6};
        int last = Integer.MIN_VALUE;
        int index = inp.length - 1;
        int res = findLISIterative(inp);
        System.out.println(res);
    }


    private static int findLISRecurse(int[] inp, int last, int index) {
        if (index < 0) {
            return 0;
        }

        int including = 0;
        int notIncluding = 0;
        int third = 0;

        if (inp[index] > last) {
            including = findLISRecurse(inp, inp[index], index-1) + 1;
            notIncluding = findLISRecurse(inp, inp[index], index-1);
        } else {
            third = findLISRecurse(inp, last, index-1);
        }

        return Math.max(including, Math.max(notIncluding, third));
    }

    private static int findLISIterative(int[] inp) {
        int dp[] = new int[inp.length];
        int maxRes = 0;

        for (int i = 0; i < inp.length; i++)
            dp[i] = 1;

        for (int i = 1; i < inp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inp[i] > inp[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = 0; i < inp.length; i++)
            if (maxRes < dp[i])
                maxRes = dp[i];

        return maxRes;
    }
}
