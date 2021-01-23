package Tree;

import java.util.HashMap;
import java.util.Map;

public class HeightBalanced {
    private static Map<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        /**
         *         5
         *      2     3
         *    1
         *  1
         */
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        // root.left.left.left = new Node(1);
        //root.right.left = new Node(2);
        //root.right.right = new Node(1);
        //System.out.println(isHeightBalanced(root));
        System.out.println(height2(root) > 0 ? true : false);
    }

    private static boolean isHeightBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.abs(l-r) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }

    private static boolean isHeightBalancedN(Node root) {
        if (root == null) {
            return true;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.abs(l-r) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int height2(Node root) {
        if (root == null) {
            return 0;
        }
        int l = height2(root.left);
        int r = height2(root.right);
        if (l==-1 || r == -1 || Math.abs(l-r) > 1) {
            return -1;
        }
        int curr = 1 + Math.max(l, r);
        return curr;
    }
}
