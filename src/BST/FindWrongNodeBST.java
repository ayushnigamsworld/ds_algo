package BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Not able to do O(n) of finding two defaulters in sorted array.
 * i.e. Two numbers which are in wrong order in a sorted array.
 * Here sorted array is BST.
 */
public class FindWrongNodeBST {

    public static void main(String[] args) {
        /**
         *            20
         *       60       30
         *     4   10   8   35
         */
        Node root = new Node(20);
        root.left = new Node(60);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right = new Node(80);
        root.right.left = new Node(8);
        root.right.right = new Node(100);
        List<Node> ls = new ArrayList<>();
        /*findWrongNode(root, ls);
        List<Node> out = new ArrayList<>();
        findWronglySorted(ls, out);
        for (Node a: out) {
            System.out.print(a.data + " ");
        }*/
        findWrongNodeWithoutExtraSpace(root);
        System.out.println(first.data);
        System.out.println(second.data);
    }

    private static void findWrongNode(Node root, List<Node> list) {
        if (root != null) {
            findWrongNode(root.left, list);
            list.add(root);
            findWrongNode(root.right, list);
        }
    }

    private static void findWronglySorted(List<Node> inp, List<Node> out) {
        Node prev = new Node(Integer.MIN_VALUE);
        Node first = null, second = null;
        for (Node a: inp) {
            if (a.data < prev.data) {
                if (first == null) {
                    first = prev;
                }
                second = a;
            }
            prev = a;
        }
        out.add(first);
        out.add(second);
    }

    private static Node prev = new Node(Integer.MIN_VALUE);
    private static Node first = null;
    private static Node second = null;
    private static void findWrongNodeWithoutExtraSpace(Node root) {
        if (root != null) {
            findWrongNodeWithoutExtraSpace(root.left);
            if (root.data < prev.data) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            findWrongNodeWithoutExtraSpace(root.right);
        }
    }
}
