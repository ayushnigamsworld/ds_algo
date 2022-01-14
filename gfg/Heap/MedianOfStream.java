package Heap;

import java.util.*;

/**
 * Considering Each Element as incoming event of stream,
 * given an array on each element find median till that element.
 *
 * Solution:
 * Using 2 heaps:
 * Max Heap and Min Heap.
 * NOT ABLE TO DO.
 */
public class MedianOfStream {

    static List<Double> out = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(25);
        ls.add(7);
        ls.add(10);
        ls.add(15);
        ls.add(20);
        for (Integer a: ls) {
            medianOfSequence(a);
        }
        for (Double b: out) {
            System.out.println(b);
        }
    }












    /**
     * Using concept of 2 containers to find median.
     * Left Container contains smaller elements
     * Right Container contains bigger elements
     * Each incoming integer is allotted either of the container based on numbers already present there.
     * After allotment, median is taken by taking max in left container when total size is even
     * and by taking mean of (max of left side and min of right side) when total size is odd.
     * Two containers are Max Heap and Min Heap respectively.
     * @param a
     */
    private static PriorityQueue<Integer> container1 = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    private static PriorityQueue<Integer> container2 = new PriorityQueue<>(); // min heap
    private static void medianOfSequence(Integer a) {
        if (container1.isEmpty() && container2.isEmpty()) {
            container1.add(a);
            out.add(a.doubleValue());
            return;
        }
        if (container1.size() > container2.size()) {
            if (container1.peek() > a) {
                container2.offer(container1.poll());
                container1.offer(a);
            } else {
                container2.offer(a);
            }
            out.add((container1.peek().doubleValue() + container2.peek().doubleValue())/2);
        } else {
            if (container1.peek() < a) {
                container2.offer(a);
                container1.offer(container2.poll());
            } else {
                container1.offer(a);
            }
            out.add(container1.peek().doubleValue());
        }
    }

    /**
     * Using BST
     * O(nlogn)
     * @param a
     * @return
     */
    private static Set<Integer> ts = new TreeSet<>();
    private static void medianUsingBSTOfSequence(Integer a) {
        ts.add(a);
        int size = ts.size();
        if (size % 2 == 0) {
            // Find Kth Smallest in Augmented BST, Kth = Size-1/2 & size+1/2
        } else {
            // find Kth Smallest in Augmented BST, K = Size/2
        }
    }
}
