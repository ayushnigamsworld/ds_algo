package Array;

public class MaxDiff {

    public static void main(String aa[]) {
        int arr[] = new int[] {7, 1, 2, 5};
        System.out.println(maxIndexDiff(arr, 4));
    }

    /**
     * Current solution is mine. Can be made better by using L and R array storing smallest and largest elements and then comparing them.
     * @param arr
     * @param n
     * @return
     */
    static int maxIndexDiff(int arr[], int n) {

        // Your code here
        int maxi[] = new int[n];
        int tempMax = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--) {
            if (tempMax < arr[i]) {
                tempMax = arr[i];
            }
            maxi[i] = tempMax;
        }

        int i=0;
        int j = n-1;
        int maxDiff = 0;
        while(i<j) {
            if ((j-i) <= maxDiff ) {
                return maxDiff;
            }
            while (i<j && arr[i] > maxi[j]) {
                j--;
            }
            int localDiff = j - i;
            if (maxDiff < localDiff) {
                maxDiff = localDiff;
            }
            i++;
            j = n-1;
        }
        return maxDiff;
    }
}
