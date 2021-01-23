package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumber {

    public static void main(String[] args) {
        generateNumbers(new int[] {5, 6}, 10);
    }

    private static void generateNumbers(int inp[], int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(String.valueOf(inp[0]));
        queue.offer(String.valueOf(inp[1]));
        while (n-- > 0) {
            String a = queue.poll();
            System.out.println(a);
            queue.offer(a + inp[0]);
            queue.offer(a + inp[1]);
        }
    }
}
