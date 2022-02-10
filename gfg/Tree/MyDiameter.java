package Tree;

public class MyDiameter {

    private static int res = -1;
    public static void main(String[] args) {
        /**
         *           1
         *       2        3
         *    4    5         11
         *  7   8    9          14
         * 0           1
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        //root.right.left = new Node(6);
//        root.right.left.left = new Node(40);
        // root.right.right = new Node(50);
        //root.right.left.left = new Node(60);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.left.right.right = new Node(9);
        root.left.left.left.left = new Node(0);
        root.left.right.right.right = new Node(1);
        root.left.right.right.right.right = new Node(40);
        System.out.println(diameter(root, 0));
        System.out.println(res);
    }

    public static int diameter(Node root, int h) {
        if (root == null) {
            return -1;
        }
        int left = diameter(root.left, h+1);
        int right = diameter(root.right, h+1);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
