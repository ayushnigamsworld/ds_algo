package arrays.binary_search;

import java.util.Map;

/**
 * There are 2 sorted arrays A and B of size n each.
 * Write an algorithm to find the median of the array obtained after
 * merging the above 2 arrays(i.e. array of length 2n).
 * The complexity should be O(log(n)).
 *  ar1[] = {1, 12, 15, 26, 38}
    ar2[] = {2, 13, 17, 30, 45}
    So,
    (15 + 17)/2=16 should be the answer
 */
public class MedianTwoSortedSameSize {

    public static void main(String[] args) {
        int inp1[] = {1, 12, 15, 26, 38};
        int inp2[] = {2, 13, 17, 30, 45};
        int res = medianFind(inp1, inp2, 0, inp1.length - 1, 0, inp2.length - 1);
        System.out.println(res);
    }

    /**
     * NOT ABLE TO DO and UNDERSTAND.
     *
     * TODO: Youtube etc se smjho.
     * @param arr1
     * @param arr2
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    private static int medianFind(int arr1[], int arr2[], int start1, int end1, int start2, int end2) {
        if ((end1 - start1 + 1) == 2 && (end2 - start2 + 1) == 2) {
            return ( Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]) )/2;
        }
        int p1 = (start1 + end1)/2;
        int median1 = arr1[p1];
        int p2 = (start2 + end2)/2;
        int median2 = arr2[p2];
        if (median1 == median2) {
            return median1;

        } else if (median1 > median2) {
            return medianFind(arr1, arr2, start1, p1, p2, end2);
        } else {
            return medianFind(arr1, arr2, p1, end1, start2, p2);
        }
    }
}
