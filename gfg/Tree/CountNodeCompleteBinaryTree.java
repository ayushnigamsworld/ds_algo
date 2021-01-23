package Tree;

/**
 * Not able to do.
 * O(logn * logn)
 */
public class CountNodeCompleteBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(0);
        System.out.println(countCompleteTree(root));
    }

    private static int countCompleteTree(Node root) {
        if (root == null) {
            return 0;
        }
        Node temp = root;
        int lHeight = 0;
        while (temp != null) {
            temp = temp.left;
            lHeight++;
        }
        int rHeight = 0;
        temp = root;
        while (temp != null) {
            temp = temp.right;
            rHeight++;
        }
        if (lHeight != rHeight) {
            int l = countCompleteTree(root.left);
            int r = countCompleteTree(root.right);
            return l + r + 1;
        } else {
            return (int)Math.pow(2, lHeight) - 1;
        }
    }
}
