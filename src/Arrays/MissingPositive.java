package Arrays;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
 Note: Expected solution in O(n) time using constant extra space.

 Input:
 First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.

 Output:
 Single line output, print the smallest positive number missing.

 User Task:
 The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

 Constraints:
 1 <= T <= 100
 1 <= N <= 10^6
 -10^6 <= arr[i] <= 10^6

 Example:
 Input:
 2
 5
 1 2 3 4 5
 5
 0 -10 1 3 -20

 9 2 5 1 6 4
 Output:
 6
 2

 Explanation:
 Testcase 1: Smallest positive missing number is 6.
 Testcase 2: Smallest positive missing number is 2.
 */
public class MissingPositive {
    public static void main(String aa[]) {
        int[] sampleInput = new int[]{  7, 11, 9, 6, 1, 2, 3, 4, 5};
        System.out.println(missingPositive(sampleInput));
    }

    private static int missingPositive(int arr[]) {
        boolean[] checker = new boolean[1000000];
        for (int i=0;i< arr.length; i++) {
            if (arr[i] > 0) {
                checker[arr[i]] = true;
            }
        }
        for (int i = 1; i < checker.length; i++) {
            if (!checker[i]) {
                return i;
            }
        }
        return -1;
    }
}
