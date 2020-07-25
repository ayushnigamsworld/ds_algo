package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseQueeu {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        for (Integer a: queue) {
            System.out.print(a + " ");
        }
        reverse(queue);
        for (Integer a: queue) {
            System.out.print(a + " ");
        }
    }

    private static void reverse(Queue queue) {
        if (queue.size() == 0) {
            return;
        }
        Object a = queue.poll();
        reverse(queue);
        queue.offer(a);
    }
}
