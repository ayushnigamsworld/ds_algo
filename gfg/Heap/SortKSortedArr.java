package Heap;

import java.util.PriorityQueue;

/**
 * Given an array whose each element will be, given that
 * i = current position of that element, in
 * sorted position in range (i-k, i+k).
 * Need to search_sort the array now.
 *
 * Soln: Use MinHeap of size K, by maintaining.
 * Not able to do the inplace array changing part, i.e. line no 36 and 40
 */
public class SortKSortedArr {

    public static void main(String[] args) {
        int inp[] = {9, 8, 7, 18, 19, 17};
        sortKSorted(inp, 2);
        for (int a: inp) {
            System.out.println(a);
        }
    }

    /**
     * O(nlogK) which is better than O(nlogn) i.e. naive.
     * @param arr
     * @param k
     */
    private static void sortKSorted(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<=k; i++) {
            minHeap.offer(arr[i]);
        }
        int index = 0;
        for (int i=k+1; i<arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.offer(arr[i]);
        }
        for (int i=0; i<=k; i++) {
            arr[index++] = minHeap.poll();
        }
    }
}
