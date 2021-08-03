package hackerrank;

import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue();
        p.add("dishes");
        p.add("laundry");
        p.add("bills");
        p.offer("bills");

        System.out.println(p.size() + " " + p.poll());
        System.out.println(p.peek() + " " + p.poll());
        System.out.println(p.poll() + " " + p.poll());
    }
}
