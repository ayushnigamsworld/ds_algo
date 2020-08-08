package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalTraversal {

    public static void main(String[] args) {
        /**
         *            10
         *        15     5
         *      1    3 2   4
         *        10
         */
        Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.left.right = new Node(10);
        root.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        verticalTraverse(root, tm, 0);
        System.out.println(tm);
    }

    private static void verticalTraverse(Node root, TreeMap<Integer, List<Integer>> tm, int cnt) {
        if (root == null) {
            return;
        }
        if (tm.containsKey(cnt)) {
            List<Integer> ls = tm.get(cnt);
            ls.add(root.data);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.data);
            tm.put(cnt, temp);
        }
        verticalTraverse(root.left, tm, cnt - 1);
        verticalTraverse(root.right, tm, cnt + 1);
    }
}
