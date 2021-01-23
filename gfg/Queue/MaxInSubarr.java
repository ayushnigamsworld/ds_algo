package Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Khatarnaak .
 * Hum khud se na kr pae bhaiyaa.
 */
public class MaxInSubarr {
    public static void main(String[] args) {
        int o[] = maxInSubarr(new int[]{20, 5, 3, 8, 6, 15},  4);
        for (int a: o) {
            System.out.println(a);
        }
    }

    private static int[] maxInSubarr(int arr[], int k) {
        int op[] = new int[arr.length - k + 1];
        Deque<Integer> deque =  new LinkedList<>();
        for (int i=0; i<k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()] ) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for (int i=k; i<arr.length; i++) {
            op[i-k] = arr[deque.peekFirst()];
            while (!deque.isEmpty() && deque.peekFirst() <= (i-k) ) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()] ) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        op[arr.length - k] = arr[deque.peekFirst()];
        return op;
    }
}
