package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Use Case:
 * 1. Find LCA via naive method.
 */
public class FindPath {

    /**
     * Makes path from root to target node.
     * Returns if path possible or not.
     * @param root
     * @param p
     * @param target
     * @return
     */
    public static boolean findPath(Node root, List<Node> p, int target) {
        if (root == null) {
            return false;
        }
        p.add(root);
        if (root.data == target) {
            return true;
        }
        if (findPath(root.left, p, target) || findPath(root.right, p, target)) {
            return true;
        }
        p.remove(root);
        return false;
    }

    public static int findPathLength(Node root, int target) {
        List<Node> temp = new ArrayList<>();
        findPath(root, temp, target);
        return temp.size();
    }
}
