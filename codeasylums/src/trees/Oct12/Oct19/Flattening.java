package trees.Oct12.Oct19;

import trees.Oct12.MyTree;
import trees.Oct12.Node;

public class Flattening {

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
        flatten(myTree.root);
    }

    /**
     * class Solution {
     public void flatten(TreeNode root) {

     flattenUtil(root);
     }

     TreeNode flattenUtil(TreeNode root){

     if(root == null)
     return null;

     TreeNode leftNode = flattenUtil(root.left);

     TreeNode temp = root.right;

     root.left = null;

     if(leftNode!=null){

     root.right = leftNode;

     while(leftNode.right != null)
     leftNode = leftNode.right;

     leftNode.right = temp;
     }

     flattenUtil(temp);

     return root;
     }
     }
     * @param root
     */
    private static void flatten(Node root) {
        /*if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        if (left == null && prevRight != null) {
            root.right = prevRight;
        }
        root.right = left;
        flatten(left, right);*/
    }
}
