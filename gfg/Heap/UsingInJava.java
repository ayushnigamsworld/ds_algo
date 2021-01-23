package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class UsingInJava {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.offer(3);
        minHeap.offer(2);
        minHeap.offer(5);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        System.out.println(minHeap);
        System.out.println(maxHeap);
    }
}
