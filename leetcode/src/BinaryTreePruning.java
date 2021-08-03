/**
 * https://leetcode.com/problems/binary-tree-pruning/
 */

class TreeNode {
    int val;
    boolean isDeleted;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePruning {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode();
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        pruneTree(root);
        System.out.println(root);
    }
    public static boolean pruneTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        boolean leftSubtreeRoot = pruneTree(root.left);
        boolean rightSubtreeRoot = pruneTree(root.right);
        if (!leftSubtreeRoot) {
            root.left = null;
        }
        if (!rightSubtreeRoot) {
            root.right = null;
        }
        return root.val == 1 || leftSubtreeRoot || rightSubtreeRoot;
    }
}
