package easy;

public class MaxSubarray {

    public static void main(String[] args) {
        int[] inp = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarray maxSubarray = new MaxSubarray();
        int r = maxSubarray.maxSubarray(inp);
        System.out.println(r);
    }

    public int maxSubarray(int[] arr) {
        int maxRes = 0;
        int finalMax = 0;
        for (int i=0; i<arr.length; i++) {
            maxRes += arr[i];
            finalMax = Math.max(maxRes, finalMax);
            if (maxRes < 0) {
                maxRes = 0;
            }
        }
        return finalMax;
    }

    public int maxDp(int[] arr) {
        int[] dp = new int[arr.length];
        int max = arr[0];
        dp[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
