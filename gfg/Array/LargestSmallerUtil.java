package Array;

import java.util.TreeSet;

public class LargestSmallerUtil {

    public static void main(String aa[]) {
        int input[] = new int[]{4,2,5,1,6,3,8,7,9};
        int input2[] = new int[]{6,7,8,1,2,3,9,10};
        int output[] = largestSmallerOptimized(input2);
        for (int i=0; i< input2.length; i++) {
            System.out.print(output[i] + " ");
        }
    }

    private static int[] largestSmallerOptimized(int arr[]) {
        int n = arr.length;
        int L[] = new int[n];
        // Main problem is to find greatest element smaller than current element.
        // This requires some type of sorting but with better efficiency.
        // Therefore using TreeSet to store and using lower() to get that element.
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=0; i< n; i++) {
            treeSet.add(arr[i]);
            Integer greatestSmaller = treeSet.lower(arr[i]);

            if (greatestSmaller == null) {
                L[i] = -1;

            } else {
                L[i] = greatestSmaller;
            }
        }

        return L;
    }

    /**
     * O(n^2) solution.
     * @param arr
     */
    private static void largestSmaller(int arr[]) {
        int n = arr.length;
        int L[] = new int[n];

        L[0] = 0;
        int maxTillNow = 0;
        int minTillNow = Integer.MAX_VALUE;
        for (int i=1; i<n; i++) {
            if (maxTillNow < arr[i-1]) {
                maxTillNow = arr[i-1];
            }
            if (minTillNow > arr[i-1]) {
                minTillNow = arr[i-1];
            }
            if (arr[i] > arr[i-1]) {
                if (arr[i] > maxTillNow) {
                    L[i] = maxTillNow;
                } else {
                    L[i] = arr[i-1];
                }
            } else {
                int j = i-1;
                int localMax = 0;
                while (arr[j] != minTillNow  ) {
                    if (arr[j] < arr[i] && localMax < arr[j]) {
                        localMax = arr[j];
                    }
                    j--;
                }
                L[i] = localMax;
            }
        }
    }
}
