package arrays.two_pointer;

/**
 *  Given array, find maximum sum of subsequence such that no two adjacent element are of subsequence.
 *  Input:  {5, 5, 10, 100, 10, 5}
 *  Output: 110   (i.e. 5 + 100 + 5)
 */
public class MaxSumSubsequenceNonAdjacent {
    public static void main(String[] args) {
        int inp[] = {5, 5, 10, 100, 10, 5};
        System.out.println(calculate(inp));
    }

    /**
     * Use principle of Include and Exclude each element.
     * Keep Max Sum till Now Including previous element s1
     * Keep Max Sum till Now Excluding previous element s2
     * For each number, s2 = max(s1, s2) // keeping max till now by excluded current element.
     *                  s1 = original s2 + arr[i] // because s2 has excluded prev element, thus wont be adjacent.
     *
     */
    private static int calculate(int arr[]) {
        int maxSumIncludingLast = arr[0];
        int maxSumExcludingLast = 0;
        for (int i=1; i<arr.length; i++) {
            int temp = maxSumExcludingLast;
            maxSumExcludingLast = Math.max(maxSumExcludingLast, maxSumIncludingLast);
            maxSumIncludingLast = temp + arr[i];
        }
        return Math.max(maxSumIncludingLast, maxSumExcludingLast);
    }

}
