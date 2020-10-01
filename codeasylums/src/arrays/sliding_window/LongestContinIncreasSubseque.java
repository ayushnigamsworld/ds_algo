package arrays.sliding_window;

public class LongestContinIncreasSubseque {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[] {2,2,2,2,2}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 1;
        int start = 0;
        int end = 1;
        while(start < nums.length && end < nums.length) {
            if (nums[end] > nums[end-1]) {
                end++;

            } else {
                res = Math.max(res, end - start);
                start = end;
                end++;
            }
        }
        res = Math.max(res, end - start);
        return res;
    }
}
