package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a leaf node, how many turns it takes to delete whole tree.
 * Khatarnaak problem.
 * Not able to do optimized solution.
 * Should see: https://practice.geeksforgeeks.org/tracks/PC-W6-T/?batchId=135
 *
 * Modified height thing.
 */
public class BurnLeaf {

    public static void main(String[] args) {
        /**
         *             10
         *         20      30
         *      40    50
         *   60
         * 70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        // System.out.println(burnLeafNaive(root, 50));
        burnLeafOn(root, 50, new Distance(-1));
        System.out.println(res);
    }

    static class Distance {
        int val;
        Distance(int v) {
            this.val = v;
        }
    }
    private static int res = 0;
    private static int burnLeafOn(Node root, int target, Distance dist) {
        if (root == null) {
            return 0;
        }
        if (root.data == target) {
            dist.val = 0;
            return 1;
        }
        Distance lDist = new Distance(-1);
        Distance rDist = new Distance(-1);
        int leftHeight = burnLeafOn(root.left, target, lDist);
        int rightHeight = burnLeafOn(root.right, target, rDist);
        if (lDist.val != -1) {
            dist.val = lDist.val + 1;
            res = Math.max(res, rightHeight + dist.val);
        }
        if (rDist.val != -1) {
            dist.val = rDist.val + 1;
            res = Math.max(res, leftHeight + dist.val);
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static int burnLeafNaive(Node root, int target) {
        if (root == null) {
            return -1;
        }
        List<Integer> leaves = findAllLeaves(root, new ArrayList<>());
        int max = -1;
        for (Integer a: leaves) {
            if (a != target) {
                max = Math.max(max, findPathBetweenTwoNodes(root, a, target));
            }
        }
        max = Math.max(max, findPathBetweenTwoNodes(root, root.data, target));
        return max-1;
    }

    private static List<Integer> findAllLeaves(Node root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }
        if (root.left == null && root.right == null) {
            arr.add(root.data);
        }
        findAllLeaves(root.left, arr);
        findAllLeaves(root.right, arr);
        return arr;
    }

    private static int findPathBetweenTwoNodes(Node root, Integer a, Integer b) {
        Node lcaRoot = LCA.lca(root, a, b);
        int left = FindPath.findPathLength(lcaRoot, a);
        int right = FindPath.findPathLength(lcaRoot, b);
        return left + right - 1;
    }

    private static boolean find13AncestorWithPosition(Node root, Map<Node, Boolean> pp, int target) {
        if (root == null) {
            return false;
        }
        pp.put(root, true);
        if (root.data == target) {
            return true;
        }
        /*Boolean l = findAncestorWithPosition(root.left, pp, target);
        if (l) {
            pp.put(root, true);
            return true;
        }
        Boolean r = findAncestorWithPosition(root.left, pp, target);*/
        /*if (r) {
            pp.put(root, false);
            return true;
        }*/
        pp.put(root, null);
        return false;
    }
}
