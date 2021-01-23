package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        String[] op = generateBinaryUsingQ(15);
        for (String a: op) {
            // System.out.println(a);
        }
    }

    public static String[] generateBinary(int n) {
        int i= 0;
        String[] op = new String[n+1];
        while (i<=n) {
            op[i] = Integer.toBinaryString(i);
            i++;
        }
        return op;
    }

    public static String[] generateBinaryUsingQ(int n) {
        String[] str = new String[n];
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0");
        queue.offer("1");
        while (n-- > 0) {
            String a = queue.poll();
            System.out.println(a);
            queue.offer(a + "0");
            queue.offer(a + "1");
        }
        return str;
    }
}
