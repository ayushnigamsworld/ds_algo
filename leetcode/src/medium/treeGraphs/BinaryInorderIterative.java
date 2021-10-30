package medium.treeGraphs;

import java.util.*;

public class BinaryInorderIterative {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(12);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(0);
        root.right.left.right = new TreeNode(66);
        root.right.left.right.right = new TreeNode(67);
        root.right.right = new TreeNode(4);
        BinaryInorderIterative binaryInorderIterative = new BinaryInorderIterative();
        // binaryInorderIterative.inorder(root);
        System.out.println(binaryInorderIterative.inorderIterative(root));
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    private List<Integer> inorderIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        visited.add(root);
        while (!stack.isEmpty()) {
            TreeNode leftTemp = stack.peek();
            if (!visited.contains(leftTemp.left)) {
                while (leftTemp.left != null) {
                    stack.push(leftTemp.left);
                    leftTemp = leftTemp.left;
                }
            }
            TreeNode current = stack.pop();
            visited.add(current);
            res.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
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