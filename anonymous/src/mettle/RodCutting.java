package mettle;

public class RodCutting {

    public static void main(String[] args) {

    }

    public int harry(int input1, int[] input2) {
        int[] arr = new int[input1];
        for (int i=0; i<input1; i++) {
            arr[i] = input2[i+1];
        }
        int dp[] = new int[input1+1];
        dp[0] = 0;

        for (int i = 1; i<=input1; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        arr[j] + dp[i-j-1]);
            dp[i] = max_val;
        }

        return dp[input1];
    }
}
