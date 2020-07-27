package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Lowest Common Ancestor
 */
public class LCA {

    public static void main(String[] args) {
        /**
         *             1
         *       2         3
         *    4     5         11
         *  7   8
         *10
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.left.left.left.left = new Node(10);
        System.out.println(lca(root, 7, 11).data);
        System.out.println(lca(root, 7, 5).data);
        System.out.println(lca(root, 8, 5).data);
        System.out.println(lca(root, 8, 3).data);
        System.out.println(lcaNaive(root, 8, 3));
    }

    private static Node lca(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }
        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);
        if (l != null && (l.data == a || l.data == b) && r!= null && (r.data == b || r.data == a)) {
            return root;
        }
        if (l!= null) {
            return l;
        }
        return r;
    }

    /**
     * Finds path from root to a and b
     * Then finds last common node to be the answer.
     * @param root
     * @param a
     * @param b
     * @return
     */
    private static int lcaNaive(Node root, int a, int b) {
        List<Node> path1 = new ArrayList<>();
        FindPath.findPath(root, path1, a);
        List<Node> path2 = new ArrayList<>();
        FindPath.findPath(root, path2, b);
        int lastCommon = -1;
        for (int i=0; i<Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                lastCommon = path1.get(i).data;
            }
        }
        return lastCommon;
    }
}
