package BST;

/**
 * Simpler logical explanation.
 * Did but took a lot of time.
 * Better Idea:
 * Whenever root.data < x, mark that as floor.
 * Let it finish till a null node is reached.
 * My Idea was:
 * If root.right  == null then root is answer
 * if root.data < x, keep res = root and when left
 */
public class Floor {

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
        System.out.println(floor(root, 11).data);
    }

    private static Node floor(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (root.data == x) {
                return root;
            }
            if (root.data < x) {
                res = root;
                root = root.right;

            } else if (root.data > x) {
                root = root.left;
            }
        }
        return res;
    }
}
