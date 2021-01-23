package trees.Oct12;

public class InvertMirror {
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        myTree.root.right.right = new Node(6);
        myTree.root.right.right.right = new Node(7);
        invertTree(myTree.root);
        System.out.println(myTree.root);
    }

    private static void invertTree(Node root) {
        if (root == null) {
            return;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
    }

    private static void swapChildren(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
