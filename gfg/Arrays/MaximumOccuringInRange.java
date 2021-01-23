package Arrays;

/**
 * Prefix sum, tricky question.
 * Find maximum occurring element in given ranges.
 */
public class MaximumOccuringInRange {

    private static int maxOccuring(int L[], int R[]) {
        int result = 0;
        int max_R= Integer.MIN_VALUE;
        int min_L = Integer.MAX_VALUE;
        for (int i=0;i< R.length; i++) {
            if (max_R < R[i]) {
                max_R = R[i];
            }
        }
        for (int i=0; i < L.length; i++) {
            if (min_L > L[i]) {
                min_L = L[i];
            }
        }
        int arr[] = new int[max_R+1];
        for (int i=0; i< L.length; i++) {
            arr[L[i]] = arr[L[i]] + 1;
            arr[R[i] + 1] = arr[R[i]] - 1;
        }
        int sum = 0;
        for (int i=1;i <arr.length; i++) {
            arr[i] = arr[i] + arr[i-1];
        }
        int max = Integer.MIN_VALUE;
        for (int i =0;i <arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                result = i;
            }
        }
        return result;
    }
}
