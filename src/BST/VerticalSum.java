package BST;

import java.util.TreeMap;

/**
 * Vertical Sum in Binary Tree
 */
public class VerticalSum {

    public static void main(String[] args) {
        /**
         *          10
         *        15   5
         *      1    2
         */
        Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(1);
        root.right = new Node(5);
        root.right.left = new Node(2);
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        verticalSum(root, mp, 0);
        System.out.println(mp);
    }

    private static void verticalSum(Node root, TreeMap<Integer, Integer> map, int cnt) {
        if (root == null) {
            return;
        }
        verticalSum(root.left, map, cnt - 1);
        if (map.containsKey(cnt)) {
            Integer a = map.get(cnt);
            map.put(cnt, a + root.data);
        } else {
            map.put(cnt, root.data);
        }
        verticalSum(root.right, map, cnt + 1);
    }
}
