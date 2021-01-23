package trees.Oct12.Oct19;

import trees.Oct12.MyTree;
import trees.Oct12.Node;

import java.util.HashMap;
import java.util.Map;

public class Diameter {
    /**
     *          5
     *      3        8
     *   1     4  11    9
     */
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(5);
        myTree.root.left = new Node(3);
        myTree.root.right = new Node(8);
        myTree.root.left.left = new Node(1);
        myTree.root.left.right = new Node(4);
        myTree.root.right.left = new Node(11);
        myTree.root.right.right = new Node(9);
        diameter(myTree.root);
    }

    private static int maxTillNow = -2;
    private static Map<Node, Integer> cache = new HashMap<>();

    private static void diameter(Node root) {
        if (root != null) {
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);
            if (maxTillNow < leftHeight + rightHeight) {
                maxTillNow = leftHeight + rightHeight;
            }
            diameter(root.left);
            diameter(root.right);
        }
    }

    private static int findHeight(Node root) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        if (root == null) {
            return 0;
        }
        int ans = 1 + Math.max(findHeight(root.left), findHeight(root.right));
        cache.put(root, ans);
        return ans;
    }

    private static int diameterMax = -1;
    private static int diameterWithHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int l = diameterWithHeight(root.left);
        int r = diameterWithHeight(root.right);
        if (diameterMax < l + r) {
            diameterMax = l + r;
        }
        return 1 + Math.max(l, r);
    }
}
