package BST;

public class Search {

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
        System.out.println(search(root, 11));
    }

    private static boolean search(Node root, int a) {
        if (root == null) {
            return false;
        }
        if (root.data == a) {
            return true;
        }
        if (root.data < a) {
            return search(root.right, a);
        }
        return search(root.left, a);
    }
}
