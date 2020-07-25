package Tree;

/**
 * Not able to do.
 */
public class TreeFromInorderPreorder {

    static int preIndex = 0;

    public static void main(String[] args) {

    }

    private static Node constructFromInorderPreOrder(int inorder[], int preorder[]) {
        Node root = new Node(preorder[0]);
        return root;
    }
}
