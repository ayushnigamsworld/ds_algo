package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    public static void main(String[] args) {
        /**
         *         5
         *      2      3
         *    1   1  2   1
         *  6
         */
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.left.left.left = new Node(6);
        System.out.println(maxWidth(root));
    }

    private static int maxWidth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int a = queue.size();
            maxWidth = Math.max(maxWidth, a);
            for (int i=0; i< a; i++) {
                Node b = queue.poll();
                if (b.left != null) { queue.offer(b.left); }
                if (b.right != null) { queue.offer(b.right); }
            }
        }
        return maxWidth;
    }
}
