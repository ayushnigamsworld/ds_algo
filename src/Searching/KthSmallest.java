package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

 Expected Time Complexity: O(n)

 Input:
 The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

 Output:
 Corresponding to each test case, print the kth smallest element in a new line.

 Constraints:
 1 <= T <= 100
 1 <= N <= 105
 1 <= arr[i] <= 105
 1 <= K <= N

 Example:
 Input:
 2
 6
 7 10 4 3 20 15
 3
 5
 7 10 4 20 15
 4

 Output:
 7
 15

 Explanation:
 Testcase 1: 3rd smallest element in the given array is 7.
 */

public class KthSmallest {

    public static void main(String aa[]) throws IOException {
        //int input[] = {3, 2, 8, 11, 1, 4, 12, 6, 7};
        //partition(input, 0, input.length - 1);
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            int arr[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            for(int i = 0; i < n; i++)
                arr[(int)i] = Integer.parseInt(st[(int)i]);

            int K = Integer.parseInt(read.readLine());

            System.out.println(kthSmallest(arr, 0, arr.length -1, K-1));
        }
    }

    private static int partition(int arr[], int low, int high) {
        Random r = new Random();
        int randd = r.nextInt(high - low + 1) + low;
        swap(arr, randd, high);
        int pivot = arr[high];
        int pivotPtr = low;

        for (int i=low; i<=high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pivotPtr);
                pivotPtr++;
            }
        }
        swap(arr, pivotPtr, high);
        return pivotPtr;
    }

    private static void swap(int arr[], int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static int kthSmallest(int arr[], int low, int high, int k) {
        int p = partition(arr, low, high);
        if (p == k) {
            return arr[p];
        } else if (p < k) {
            return kthSmallest(arr, p+1, high, k);
        } else  {
            return kthSmallest(arr, low, p-1, k);
        }
    }
}
