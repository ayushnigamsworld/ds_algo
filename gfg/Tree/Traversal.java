package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inorder(root);
        System.out.println("----------------------");
        preorder(root);
        System.out.println("----------------------");
        postorder(root);
        System.out.println("----------------------");
        levelOrder2(root);
    }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    private static void preorder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            queue.offer(null);
        }
        while (!queue.isEmpty()) {
            Node a = queue.poll();
            if (a == null) {
                System.out.println();
                continue;
            }
            System.out.print(a.data + " ");
            if (a.left != null)
                queue.offer(a.left);
            if (a.right != null)
                queue.offer(a.right);
            queue.offer(null);
        }
    }

    private static void levelOrder2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int ss = queue.size();
            for (int i=0; i<ss; i++) {
                Node a = queue.poll();
                System.out.print(a.data + " ");
                if (a.left != null)
                    queue.offer(a.left);
                if (a.right != null)
                    queue.offer(a.right);
            }
            System.out.println();
        }
    }
}
