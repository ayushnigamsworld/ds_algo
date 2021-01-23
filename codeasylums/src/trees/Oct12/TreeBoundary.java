package trees.Oct12;

import java.util.ArrayList;
import java.util.List;

public class TreeBoundary {
    /**
     *              1
     *           2     3
     *        4    5      6
     *                       7
     * @param args
     */
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        myTree.root.right.right = new Node(6);
        myTree.root.right.right.right = new Node(7);
        boundary(myTree.root);
    }

    private static void boundary(Node root) {
        List<Integer> result = new ArrayList<>();
        leftView(root);
        //bottomView(root, result);
        //rightView(root,result);
    }

    private static void leftView(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return;
            }
            if (root.left == null) {
                leftView(root.right);
            }
            System.out.println(root.data);
            leftView(root.left);
        }
    }

    private static void rightView(Node root, List<Integer> elements) {
        if (root == null) {
            return;
        }
        rightView(root.right, elements);
        rightView(root.left, elements);
    }

    private static void bottomView(Node root, List<Integer> elements) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            elements.add((int)root.data);
            return;
        }
        bottomView(root.left, elements);
        bottomView(root.right, elements);
    }
}
