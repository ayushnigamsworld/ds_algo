package Arrays;

/**
 *
 * Prefix sum programming
 */
public class Equilibrium {

    public static void main(String aa[]) {
        long input[] = {3, 4, 8, -9, 20, 6, -1, 1};
        System.out.println(equilibriumPoint(input, input.length));
    }
    private static int findEquilibrium (int arr[]) {
        int total_sum = 0;
        for  (int  i=0; i< arr.length; i++) {
            total_sum += arr[i];
        }
        int left_sum = 0;
        for (int i=0; i< arr.length; i++) {
            int right_sum = total_sum - left_sum - arr[i];
            if (left_sum == right_sum) {
                return arr[i];
            }
            left_sum += arr[i];
        }
        return -111111111;
    }

    public static int equilibriumPoint(long arr[], int n) {
        // Your code here
        long prefsum[] = new long[n];
        long sum = 0;
        for (int i=0; i< n; i++) {
            sum += arr[i];
            prefsum[i] = sum;
        }
        for (int i=0; i< n; i++) {
            long leftSum = i-1 >= 0 ? prefsum[i-1] : 0;
            long rightSum = i == n-1 ? prefsum[n-1] - leftSum : prefsum[n-1] - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i+1;
            }
        }
        return -1;
    }
}
