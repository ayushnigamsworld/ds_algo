package trees.Oct12;

public class Height {
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        myTree.root.right.right = new Node(6);
        myTree.root.right.right.right = new Node(7);
        System.out.println(getHeight(myTree.root, -1));
    }
    private static int getHeight(Node root, int level) {
        if (root == null) {
            return level;
        }
        int l = getHeight(root.left, level + 1);
        int r = getHeight(root.right, level + 1);
        return Math.max(l, r);
    }
}
