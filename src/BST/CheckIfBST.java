package BST;

public class CheckIfBST {
    public static void main(String[] args) {
        /**
         *          20
         *        8    30
         *           18   35
         */
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(18);
        root.right.right = new Node(35);
        System.out.println(isBST(root));
    }

    private static int prev = Integer.MIN_VALUE;

    private static boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        if (!isBST(root.left)) return false;
        if (prev > root.data) return false;
        prev = root.data;
        return isBST(root.right);
    }
}
