package trees.Oct12.Oct16;

import trees.Oct12.MyTree;
import trees.Oct12.Node;

public class CheckBST {
    /**
     *          5
     *      3        8
     *   1     4  11    9
     */
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(5);
        myTree.root.left = new Node(3);
        myTree.root.right = new Node(8);
        myTree.root.left.left = new Node(1);
        myTree.root.left.right = new Node(4);
        myTree.root.right.left = new Node(11);
        myTree.root.right.right = new Node(9);
        // System.out.println(isBST(myTree.root));
        System.out.println(isBST(myTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static Node<Integer> prev = null;


    private static boolean isBST(Node<Integer> root) {
        if (root != null) {
            if (!isBST(root.left)) {
                return false;
            }
            if(prev != null && prev.data > root.data) {
                return false;
            }
            prev = root;
            return isBST(root.right);
        }
        return true;
    }

    /**
     * boolean checkIsBST(TreeNode root, int min, int max){

     if(root == null)
     return true;

     if(root.value>max || root.value<min)
     return false;

     return (checkIsBST(root.left, min, root.value-1)&&checkIsBST(root.right, root.value+1, max));
     }
     * @param root
     * @return
     */
    private static boolean isBST(Node<Integer> root, int min, int max) {
        if (root != null) {
            if (min > root.data || root.data > max) {
                return false;
            }
            if (!isBST(root.left, min, root.data-1)){
                return false;
            }
            return isBST(root.right, root.data+1, max);
        }
        return true;
    }
}
