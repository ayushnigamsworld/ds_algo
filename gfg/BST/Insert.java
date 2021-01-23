package BST;

public class Insert {

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
//        insert(root, 11);
        insertIterative(root, 11);
        if (root.right.left.left.data == 11) {
            System.out.println(true);
        }
    }

    private static Node insert(Node root, int a) {
        if (root == null) {
            return new Node(a);
        }
        if (root.data == a) {
            return null;
        } else if (root.data < a) {
            root.right = insert(root.right, a);
        } else {
            root.left = insert(root.left, a);
        }
        return root;
    }

    private static void insertIterative(Node root, int a) {
        Node last = null;
        while (root != null) {
            if (root.data < a) {
                last = root;
                root = root.right;
            } else if (root.data > a){
                last = root;
                root = root.left;
            } else {

            }
        }
        if (last.data < a) {
            last.right = new Node(a);
        } else {
            last.left = new Node(a);
        }
    }
}
