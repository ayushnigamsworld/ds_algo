package trees.Oct12.Oct16;

import trees.Oct12.MyTree;
import trees.Oct12.Node;

public class LCA {

    /**
     *          1
     *       2    3
     *     4   5    6
     *                7
     * @param args
     */
    private static int count = 0;
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        myTree.root.right.right = new Node(6);
        myTree.root.right.right.right = new Node(7);
        Node result = LCA(myTree.root, myTree.root.right, myTree.root.right.right);
        System.out.println(result);
    }

    /**
     * TODO: Handle non-existent nodes.
     * @param root
     * @param first
     * @param second
     * @return
     */
    private static Node LCA(Node root, Node first, Node second) {
        if (root == null) {
            return null;
        }
        if (root == first || root == second) {
            return root;
        }
        Node left = LCA(root.left, first, second);
        Node right = LCA(root.right, first, second);
        if (left != null && right != null) {
            return count == 2 ? root : null;
        }
        return left != null ? left: right;
    }

}
