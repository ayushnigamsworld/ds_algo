package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Height {

    public static void main(String[] args) {
        /**
         *          1
         *      2      3
         *    4   5  6
         *  7   8
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        System.out.println(heightRecurse(root));
    }

    private static int height(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int a = queue.size();
            for (int i=0; i<a; i++) {
                Node p = queue.poll();
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
            count++;
        }
        return count;
    }

    private static int heightRecurse(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightRecurse(root.left), heightRecurse(root.right));
    }
}
