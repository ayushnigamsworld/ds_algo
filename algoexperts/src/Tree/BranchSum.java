package Tree;

import common.TreeNode;

public class BranchSum {

    /**
     *           1
     *       2          3
     *    4    5      6
     *  7   8   9  10  11
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        branchSum(root, 0);
    }

    private static void branchSum(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null || treeNode.right == null) {
            System.out.println(sum + treeNode.data);
        }
        branchSum(treeNode.left, sum + treeNode.data);
        branchSum(treeNode.right, sum + treeNode.data);
    }
}
