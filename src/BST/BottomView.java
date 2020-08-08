package BST;

import java.util.Map;
import java.util.TreeMap;

public class BottomView {

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
        Map<Integer, Integer> mp = new TreeMap<>();
        bottomView(root, mp, 0);
        System.out.println(mp);
    }

    private static void bottomView(Node root, Map<Integer, Integer> mp, int cnt) {
        if (root == null) {
            return;
        }
        mp.put(cnt, root.data);
        bottomView(root.left, mp, cnt - 1);
        bottomView(root.right, mp, cnt + 1);
    }
}
