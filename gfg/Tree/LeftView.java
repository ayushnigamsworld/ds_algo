package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
    static int maxLevel = 0;
    public static void main(String[] args) {
        /**
         *          1
         *       2     3
         *         5 6
         *             8
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        // root.left.right.left = new Node(7);
        root.right.left.right = new Node(8);
        leftView(root);
        // leftViewRecurse(root, 1);

    }

    private static void leftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int a = queue.size();
            for (int i=0; i<a; i++) {
                Node f = queue.poll();
                if (i ==0 ) {
                    System.out.println(f.data);
                }
                if (f.left != null)  { queue.offer(f.left); }
                if (f.right != null) { queue.offer(f.right); }
            }
        }
    }

    private static void leftViewRecurse(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }
        leftViewRecurse(root.left, level + 1);
        leftViewRecurse(root.right, level + 1);
    }
}
