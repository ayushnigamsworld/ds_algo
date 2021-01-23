package trees.Oct12.Oct16;

import trees.Oct12.MyTree;
import trees.Oct12.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    /**
     *          1
     *       2    3
     *     4   5    6
     *                7
     * @param args
     */
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        myTree.root.right.right = new Node(6);
        myTree.root.right.right.right = new Node(7);
        levelOrderTraversal(myTree.root);
    }

    /**
     * TODO: Fix this
     * @param root
     */
    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            while (queue.peek() != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                queue.poll();
            }
            if (temp == null) {
                System.out.println();
                continue;
            }
            queue.add(null);
        }
    }
}
