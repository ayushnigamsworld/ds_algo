package Array;

/**
 * Finding maximum contiguous sum array
 */
public class Kadanes {

    public static void main(String aa[]) {
        int input[] = {-1, -2, -3, -4};
        System.out.println(maximum_Contiguos_Sum(input, input.length));
    }

    public static int maximum_Contiguos_Sum(int arr[], int n) {
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
