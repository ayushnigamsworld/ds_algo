package medium.dynamicProgramming;

public class LongestIncreasingSubsequence {

    private int count = 0;
    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new
                LongestIncreasingSubsequence();
        int[] inp = {0,1,0,3,2,3};
        int res = longestIncreasingSubsequence.lis(inp, 0, 1, 0);
        System.out.println(res);
    }


    private int lis(int[] inp, int prev, int current, int count) {
        if (current >= inp.length) {
            return -1;
        }

        if (inp[current] > inp[prev]) {
           return lis(inp, current, current+1, count) + 1;
        }
        int inc = lis(inp, prev, current+1, count);
        int notInc = lis(inp, prev+1, current+1, count);
        return Math.max(inc, notInc);
    }
}
