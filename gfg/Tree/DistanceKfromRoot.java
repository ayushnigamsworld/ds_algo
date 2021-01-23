package Tree;

public class DistanceKfromRoot {
    public static void main(String[] args) {
        /**
         *          1
         *      2      3
         *    4   5  6
         *  7   8
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        distanceK(root, 2);
    }

    private static void distanceK(Node root, int count) {
        if (root == null) {
            return;
        }
        if (count == 0) {
            System.out.println(root.data);
            return;
        }
        distanceK(root.left, count-1);
        distanceK(root.right, count-1);
    }
}
