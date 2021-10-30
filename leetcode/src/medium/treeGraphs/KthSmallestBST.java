package medium.treeGraphs;

public class KthSmallestBST {

    static int res = -1;
    static int k = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        KthSmallestBST kthSmallestBST = new KthSmallestBST();
        k = 1;
        kthSmallestBST.inorder(root);
        System.out.println(res);
    }

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            k--;
            if (k == 0) {
                res = root.val;
                return;
            }
            inorder(root.right);
        }
    }
}
