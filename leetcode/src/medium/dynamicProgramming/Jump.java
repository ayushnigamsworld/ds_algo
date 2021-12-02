package medium.dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
public class Jump {

    private Boolean[] dp;
    public static void main(String[] args) {
//        int[] inp = {2,1,0,1,4};
        int[] inp = {1,3,1,0,4};
//        int[] inp = {2,3,1,1,4};
        Jump j = new Jump();
//        j.dp = new Boolean[inp.length];
//        Arrays.fill(j.dp, null);
//        System.out.println(j.jump(0, inp, j.dp));
        System.out.println(j.jump(inp));
    }

    // Greedy
    public boolean jump(int[] inp) {
        int last = inp.length-1;
        for (int i=inp.length-2; i>=0; i--) {
            int current = inp[i];
            if (i + current >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    // DP
    public Boolean jump(int currentIndex, int[] inp, Boolean[] dp) {
        if (dp[currentIndex] != null) return dp[currentIndex];
        if (currentIndex >= inp.length) {
            return false;
        }
        int current = inp[currentIndex];
        if (currentIndex == inp.length-1) {
            return true;
        }
        if (current == 0) {
            return false;
        }
        for (int i=current; i>=1; i--) {
            int temp = currentIndex + i;
            if (temp < inp.length) {
                Boolean res = jump(temp, inp, dp);
                dp[currentIndex] = res;
                if (res) return true;
            }
        }
        return false;
    }
}
