package Heap;

import java.util.PriorityQueue;

/**
 * Given items: [1, 12, 5, 111, 200]
 * Sum = 10
 * Max items can pick: 2 i.e. (1 and 5)
 */
public class PurchasingMaxItems {

    public static void main(String[] args) {
        int arr[] = {1, 12, 5, 111, 200};
        System.out.println(maxItems(arr, 10));
    }

    private static int maxItems(int arr[], int sum) {
        int result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        int temp = sum;
        while (temp > 0) {
            int i = priorityQueue.poll();
            if (i <= temp) {
                result++;
            }
            temp = temp - i;
        }
        return result;
    }
}
