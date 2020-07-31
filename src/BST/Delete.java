package BST;

/**
 * Tricky.
 * Not able to do fully.
 */

public class Delete {

    public static void main(String[] args) {
        /**
         *          10
         *        5    15
         *      1    12   18
         */
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(1);
        root.right = new Node(15);
        root.right.right = new Node(18);
        root.right.left = new Node(12);
        // findInorderPredecessor(root, 12);
        // System.out.println(res.data);
        delete(root, 10);
        System.out.println(root.right.left);
    }

    private static Node delete(Node root, int a) {
        if (root == null) {
            return null;
        }
        if (root.data == a) {
            if (root.left == null && root.right == null) {
                return null;
            }else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                findInorderPredecessor(root, root.data);
                root.data = res.data;
                root.left = delete(root.left, res.data);
            }
        } else if (root.data < a) {
            root.right = delete(root.right, a);
        } else {
            root.left = delete(root.left, a);
        }
        return root;
    }

    private static Node prev = null;
    private static Node res = null;
    private static void findInorderPredecessor(Node root, int a) {
        if (root != null) {
            findInorderPredecessor(root.left, a);
            if (root.data == a) {
                res = prev;
            }
            prev = root;
            findInorderPredecessor(root.right, a);
        }
    }
}
