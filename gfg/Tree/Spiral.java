package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Spiral {

    private static Stack<Integer> stack = new Stack<>();
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
        spiralTraversal(root);
    }

    private static void spiralTraversalQ(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean doReverse = false;
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i=0; i<s; i++) {
                Node a = queue.poll();
                if (doReverse) insertTo(a.data);
                else System.out.println(a.data);
                if (a.left != null) { queue.offer(a.left); }
                if (a.right != null) { queue.offer(a.right); }
            }
            if (doReverse) {
                while (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
            }
            doReverse = !doReverse;
        }
    }

    private static void spiralTraversal(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node a = s1.pop();
                System.out.println(a.data);
                if (a.left != null) {
                    s2.push(a.left);
                }
                if (a.right != null) {
                    s2.push(a.right);
                }
            }
            while (!s2.isEmpty()) {
                Node a = s2.pop();
                System.out.println(a.data);
                if (a.right != null) {
                    s1.push(a.right);
                }
                if (a.left != null) {
                    s1.push(a.left);
                }
            }
        }
    }

    private static void insertTo(Integer a) {
        stack.push(a);
    }
}
