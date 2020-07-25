package Tree;

/**
 *
 * Not able to do.
 */
public class ConvertToDDL {

    static Node prev = null;
    public static void main(String[] args) {
        /**
         *         10
         *      5      20
         *          30    33
         */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(30);
        root.right.right = new Node(33);
        convertInPlace(root);
    }

    private static Node convertInPlace(Node root) {

        if (root == null) { return root; }
        Node head = convertInPlace(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertInPlace(root.right);
        return head;
    }
}
