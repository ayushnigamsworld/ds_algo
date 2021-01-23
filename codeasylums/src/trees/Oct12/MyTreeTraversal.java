package trees.Oct12;

import java.util.Stack;

public class MyTreeTraversal {
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        traversal(myTree.root);
        traversalIterative(myTree.root);
    }

    private static void traversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        traversal(root.left);
        traversal(root.right);
    }

    private static void traversalIterative(Node root) {
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popped = stack.pop();
            if (popped.right != null) stack.push(popped.right);
            if (popped.left != null) stack.push(popped.left);
            System.out.println(popped.data);
        }
    }
}
