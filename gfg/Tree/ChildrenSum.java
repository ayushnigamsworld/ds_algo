package Tree;

public class ChildrenSum {
    public static void main(String[] args) {
        /**
         *         5
         *      2     3
         *    1   1
         */
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(1);
        System.out.println(isChildSum(root));
    }

    private static boolean isChildSum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;
        return isChildSum(root.left) && isChildSum(root.right) && (left + right == root.data);
    }
}
