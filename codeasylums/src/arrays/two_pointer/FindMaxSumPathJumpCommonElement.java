package arrays.two_pointer;

/**
 *
 */
public class FindMaxSumPathJumpCommonElement {

    public static void main(String[] args) {

        int X[] = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int Y[] = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };
        System.out.println(calculate(X, Y));
    }

    /**
     * Main Idea is to not calculate common elements separately.
     * Traverse both arrays, just calculating sum is done smartly:
     * Two pointer approach:
     * Finding smaller of the two numbers on respective indices,
     *   Adding sum and Increasing its index
     * When common element i.e. both have same element is encountered,
     *   Add max(sum1, sum2) till now
     *   add common element
     *   reset sum1, sume2 to 0
     * Repeat same algorithm.
     */
    private static int calculate(int arr1[], int arr2[]) {
        int sum1 = 0, sum2 = 0;
        int i = 0, j = 0;
        int res = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                sum2 += arr2[j];
                j++;

            } else {
                res += Math.max(sum1, sum2) + arr1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while (i< arr1.length) {
            res += arr1[i];
            i++;
        }
        while (j< arr2.length) {
            res += arr2[i];
            j++;
        }
        return res;
    }
}
