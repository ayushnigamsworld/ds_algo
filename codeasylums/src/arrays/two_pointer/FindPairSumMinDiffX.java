package arrays.two_pointer;

/**
 * Given two sorted arrays, find pair whose sum is closest to given target.
 * Input: a1[] = {1, 4, 5, 7}; a2[] = {10, 20, 30, 40};
 *  V = 32
 * Output: 1 and 30
   Input: a1[] = {1, 4, 5, 7}; a2[] = {10, 20, 30, 40};
    V = 50
   Output: 7 and 40
 */

public class FindPairSumMinDiffX {
    public static void main(String[] args) {
        int a1[] = {1, 4, 5, 7};
        int a2[] = {10, 20, 30, 40};
        int res[] = calculate(a1, a2, 26);
        for (int a: res) {
            System.out.println(a);
        }
    }

    /**
     * Using 2 pointers p1, p2; placed on opposite ends of given arr.
     * Add both elements, which pointers, = temp_sum
     * if temp_sum - given_sum < diffTillNow
     *    diffTillNow = temp_sum - given_sum
     *    res = [p1, p2]
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] calculate(int arr1[], int arr2[], int target) {
        int p1 = 0;
        int p2 = arr2.length -1;
        int diff = Integer.MAX_VALUE;
        int res[] = new int[2];
        while (p1 < arr1.length && p2 >= 0) {
            int sum = arr1[p1] + arr2[p2];
            int tempDiff = Math.abs(sum - target);
            if (tempDiff < diff) {
                res[0] = arr1[p1];
                res[1] = arr2[p2];
                diff = tempDiff;
            }
            if (sum < target) {
                p1++;
            } else if (sum > target) {
                p2--;
            } else {
                res[0] = arr1[p1];
                res[1] = arr2[p2];
                break;
            }
        }
        return res;
    }
}
