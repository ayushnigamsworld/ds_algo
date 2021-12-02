package easy.dp;

import java.util.Arrays;

public class HouseRobber {

    int[] dp;
    public static void main(String[] args) {
        int[] inp = {17,2,29,113,1};
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.dp = new int[inp.length];
        Arrays.fill(houseRobber.dp, -1);
//        int res = houseRobber.rob(inp, 0, 0, false);
//        int res = houseRobber.rob(inp, inp.length-1);
        int res = houseRobber.robDpTopDown(inp, inp.length-1);
//        int res = houseRobber.robDpBottomUp(inp);
//        int res = houseRobber.robDpBottomUpOptmzd(inp);
        System.out.println(res);
    }

    public int rob(int[] inp, int current, int s, boolean btn) {
        if (current >= inp.length) {
            return s;
        }
        int include = 0;
        if (!btn) {
            include = rob(inp, current+1, s + inp[current], true);
        }
        int notInclude = rob(inp, current+1, s, false);
        return Math.max(include, notInclude);
    }

    // following are from disc of leetcode::
    public int rob(int[] inp, int current) {
        if (current < 0) {
            return 0;
        }
        int include = rob(inp, current - 2) + inp[current];
        int notInclude = rob(inp, current - 1);
        return Math.max(include, notInclude);
    }

    public int robDpTopDown(int[] inp, int current) {
        if (current < 0) {
            return 0;
        }
        if (dp[current] != -1) {
            return dp[current];
        }
        int included = robDpTopDown(inp, current-2) + inp[current];
        int notIncluded = robDpTopDown(inp, current - 1);
        int res = Math.max(included, notIncluded);
        dp[current] = res;
        return res;
    }

    public int robDpBottomUp(int[] inp) {
        dp[0] = inp[0];
        dp[1] = Math.max(inp[0], inp[1]);
        for (int i=2; i<inp.length; i++) {
            dp[i] = Math.max(dp[i-2] + inp[i], dp[i-1]);
        }
        return dp[inp.length-1];
    }

    public int robDpBottomUpOptmzd(int[] inp) {
        int first = inp[0];
        int second = Math.max(inp[0], inp[1]);
        int res = 0;
        for (int i=2; i<inp.length; i++) {
            res = Math.max(first + inp[i], second);
            first = second;
            second = res;
        }
        return res;
    }
}
