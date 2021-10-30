package Array;

/**
 * Variation of Kadane's
 *
 * Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contigious subarray sum.

 Input:
 First line of input contains a single integer T which denotes the number of test cases. First line of each test case contains a single integer N which denotes the total number of elements. Second line of each test case contains N space separated integers denoting the elements of the array.

 Output:
 For each test case print the maximum sum obtained by adding the consecutive elements.

 User Task:
 The task is to complete the function circularSubarraySum() which finds the circular subarray with maximum sum.

 Constraints:
 1 <= T <= 101
 1 <= N <= 106
 -106 <= Arr[i] <= 106

 Example:
 Input:
 3
 7
 8 -8 9 -9 10 -11 12
 8
 10 -3 -4 7 6 5 -4 -1
 8
 -1 40 -14 7 6 5 -4 -1

 Output:
 22
 23
 52

 Explanation:
 Testcase 1: Starting from last element of the array, i.e, 12, and moving in circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
 */
public class CircularMaxContiguosSum {

    public static void main(String aa[]) {
        //int input[] = {8, -8, 9, -9, 10, -11, 12};
        int input[] = {-1, -2, -3, -4};
        System.out.println(circularSubarraySum(input, input.length));
    }

    static int circularSubarraySum(int a[], int n) {

        // Your code here
        // All Negative elements
        int regMax = Integer.MIN_VALUE;
        int count = 0;
        for (int i=0; i<n; i++) {
            if (regMax < a[i]) {
                regMax = a[i];
            }
            if (a[i] < 0) {
                count++;
            }
        }
        if (count == n) {
            return regMax;
        }

        int normalKadane = kadane(a, n);
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += a[i];
            a[i] = -a[i];
        }
        int negativeKadane = kadane(a, n);
        int circularKadane = negativeKadane + sum;
        return Math.max(normalKadane, circularKadane);
    }

    static int kadane(int arr[], int n) {
        int maxTillNow = 0;
        int maxFinal = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            maxTillNow += arr[i];
            if (maxFinal < maxTillNow) {
                maxFinal = maxTillNow;
            }
            if (maxTillNow < 0) {
                maxTillNow = 0;
            }
        }
        return maxFinal;
    }
}
