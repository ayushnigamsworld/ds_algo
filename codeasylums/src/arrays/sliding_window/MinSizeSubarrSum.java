package arrays.sliding_window;

public class MinSizeSubarrSum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int temp = nums[0];
        int res = Integer.MAX_VALUE;
        while (start < nums.length && end < nums.length) {
            if (temp < s) {
                end++;
                temp += end < nums.length ? nums[end] : 0;

            } else if (temp >= s) {
                if (res > (end - start + 1)) {
                    res = end - start + 1;
                }
                temp -= start < nums.length ? nums[start] : 0;
                start++;
            }
        }
        return res;
    }
}
