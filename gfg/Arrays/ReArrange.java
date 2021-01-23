package Arrays;

/**
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.

 Note: O(1) extra space is allowed. Also, try to modify the input array as required.

 Input:
 First line of input conatins number of test cases T. First line of test case contain an integer denoting the array size N and second line of test case contain N space separated integers denoting the array elements.

 Output:
 Output the modified array with alternated elements.

 User Task:
 The task is to complete the function rearrange() which rearranges elements and shouldn't print anything. Printing of the modified array will be handled by driver code.

 Constraints:
 1 <= T <= 100
 1 <= N <= 107
 1 <= arr[i] <= 107

 Example:
 Input:
 2
 6
 1 2 3 4 5 6
 11
 10 20 30 40 50 60 70 80 90 100 110

 Output:
 6 1 5 2 4 3
 110 10 100 20 90 30 80 40 70 50 60

 Explanation:
 Testcase 1: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.
 */

public class ReArrange {
    public static void main(String aa[]) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        reArrange(arr, 8);
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + " "); // SOP is slow. Use StringBuilder and append and then print.
        }
    }

    /**
     * Using Dividend Quotient Remainder, storing 2 elements same index technique
     * @param arr
     * @param n
     */
    private static void reArrange(int arr[], int n) {
        int minIndex = 0;
        int maxIndex = n -1;
        int fixedMaxElement = arr[n-1] + 1;
        for (int i=0; i< n; i++) {
            // if index is even, store current element and max(1st, 2nd, etc) elements
            if (i % 2 == 0) {
                // Value1 ->  arr[i]
                // Value2 -> arr[maxIndex]
                arr[i] = arr[i] + (arr[maxIndex] % fixedMaxElement)* fixedMaxElement;
                maxIndex --;

            } else {
                // Value1 ->  arr[i]
                // Value2 -> arr[minIndex]
                arr[i] = arr[i] + (arr[minIndex] % fixedMaxElement)* fixedMaxElement;
                minIndex ++;
            }
        }

        for (int i=0; i< n; i++) {
            arr[i] = arr[i] / fixedMaxElement; // Since we want Value2 in result
        }
    }
}
