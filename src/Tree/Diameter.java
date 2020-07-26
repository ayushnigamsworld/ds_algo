package Tree;

import java.util.HashMap;
import java.util.Map;

public class Diameter {

    private static int res = -1;
    private static Map<Node, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        /**
         *           1
         *       2        3
         *    4    5         11
         *  7   8    9          14
         * 0           1
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        //root.right.left = new Node(6);
//        root.right.left.left = new Node(40);
       // root.right.right = new Node(50);
        //root.right.left.left = new Node(60);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.left.right.right = new Node(9);
        root.left.left.left.left = new Node(0);
        root.left.right.right.right = new Node(1);
        root.left.right.right.right.right = new Node(40);
        System.out.println(getDiameterOn(root));
        System.out.println(res);
    }

    /**
     * O(n) time
     * O(n) space
     * @param root
     * @return
     */
    private static int getDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        getDiameter(root.left);
        getDiameter(root.right);
        /*int leftHeight = height(root.left);
        int rightHeight = height(root.right);*/
        int leftHeight = 0;
        if ( hm.containsKey(root.left) ) {
            leftHeight = hm.get(root.left);
        } else {
            leftHeight = height(root.left);
            hm.put(root.left, leftHeight);
        }
        int rightHeight = 0;
        if ( hm.containsKey(root.right) ) {
            rightHeight = hm.get(root.right);
        } else {
            rightHeight = height(root.right);
            hm.put(root.right, rightHeight);
        }
        int max = leftHeight + rightHeight + 1;
        res = Math.max(res, max);
        return res;
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Modify the height function as seen in Height Balanced
     * O(n) time
     * O(1) space
     * @param root
     * @return
     */
    private static int getDiameterOn(Node root) {
        if (root == null) {
            return 0;
        }
        int l = getDiameterOn(root.left);
        int r = getDiameterOn(root.right);
        res = Math.max(res, 1 + l + r);
        return 1 + Math.max(l, r);
    }
}
