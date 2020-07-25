package Tree;

public class SizeOfTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(sizeRecurse(root, 0));
    }

    private static int sizeOfTree(Node root, int count) {
        if (root!= null) {
            count++;
            count = sizeOfTree(root.left, count);
            count = sizeOfTree(root.right, count);
        }
        return count;
    }

    private static int sizeRecurse(Node root, int count) {
        if (root == null) {
            return 0;
        }
        return 1 + sizeRecurse(root.left, count+1) + sizeRecurse(root.right, count + 1);
    }
}
