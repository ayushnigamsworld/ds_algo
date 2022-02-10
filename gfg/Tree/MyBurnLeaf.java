package Tree;

public class MyBurnLeaf {

    private static int res = 0;
    public static void main(String[] args) {

        /**
         *           1
         *       2        3
         *    4    5         11
         *  7   8    9          14
         * 0
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

        findHeightWithBurnTreeTime(root, 9, new DistFromLeaf(-1));
        System.out.println(res);
    }

    private static int findHeightWithBurnTreeTime(Node root, int leaf, DistFromLeaf dist) {
        if (root == null) {
            return 0;
        }

        if (root.data == leaf) {
            dist.val = 0;
            return 1;
        }
        DistFromLeaf leftDistance = new DistFromLeaf(-1);
        DistFromLeaf rightDistance = new DistFromLeaf(-1);

        int leftHeight = findHeightWithBurnTreeTime(root.left, leaf, leftDistance);
        int rightHeight = findHeightWithBurnTreeTime(root.right, leaf, rightDistance);

        if (leftDistance.val != -1) {
            dist.val = leftDistance.val + 1;
            res = Math.max(res, rightHeight + dist.val);
        }

        else if (rightDistance.val != -1) {
            dist.val = rightDistance.val + 1;
            res = Math.max(res, leftHeight + dist.val);
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class DistFromLeaf {
    int val;
    DistFromLeaf(int d) {
        this.val = d;
    }
}