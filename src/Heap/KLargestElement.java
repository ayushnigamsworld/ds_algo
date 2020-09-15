package Heap;

import java.util.PriorityQueue;

/**
 * Given an array of elements, find the K largest elements.
 */
public class KLargestElement {

    public static void main(String[] args) {
        int arr[] = {8, 6, 4, 10, 9};
        Object res[] = kLargest(arr, 3);
        for (Object a: res) {
            System.out.println(a);
        }
    }

    /**
     * Using Min Heap,
     * O(nlogK) time complexity.
     * @param arr
     * @param k
     * @return
     */
    private static Object[] kLargest(int arr[], int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i=k; i<arr.length; i++) {
            if (arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        return priorityQueue.toArray();
    }
}
