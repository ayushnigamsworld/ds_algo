package BST;

import common.TreeNode;

public class ClosestValueBST {

    public static void main(String[] args) {
        /**
         *          10
         *        5    15
         *      1    12   18
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        root.right.left = new TreeNode(12);
        System.out.println(closestValue(root, 13, -1));
    }

    private static int diffTillNow = Integer.MAX_VALUE;

    private static int closestValue(TreeNode root, int target, int closest) {
        if (root == null) {
            return closest;
        }
        int currentDiff = Math.abs(root.data - target);
        if (currentDiff < diffTillNow) {
            closest = root.data;
            diffTillNow = currentDiff;
        }
        if (root.data <= target) {
            return closestValue(root.right, target, closest);
        } else {
            return closestValue(root.left, target, closest);
        }
    }
}
