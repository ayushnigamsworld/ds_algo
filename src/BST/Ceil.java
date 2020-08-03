package BST;

public class Ceil {
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
        System.out.println(ceil(root, 14).data);
    }

    private static Node ceil(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (root.data == x) {
                return root;
            }
            else if (root.data < x) {
                root = root.right;
            }
            else if (root.data > x) {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
