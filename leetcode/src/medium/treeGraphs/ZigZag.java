package medium.treeGraphs;

import java.util.*;

public class ZigZag {

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
        ZigZag zigZag = new ZigZag();
        zigZag.normalLevelOrderTraversal(root);
        zigZag.zigzag(root);
    }

    private void normalLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> r = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode t = queue.poll();
                r.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(r);
        }
        System.out.println(res);
    }

    private void zigzag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            LinkedList<Integer> r = new LinkedList<>();
            int size = q.size();
            while (size > 0) {
                TreeNode curr = q.remove();
                if (leftToRight) {
                    r.addLast(curr.val);
                } else {
                    r.addFirst(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                size--;
            }
            leftToRight = !leftToRight;
            res.add(r);
        }
        System.out.println(res);
    }
}
