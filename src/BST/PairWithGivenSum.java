package BST;

import java.util.HashSet;
import java.util.Set;

/**
 * Find if a pair exists of given sum
 * Way 1: Use hashset and do sum - current
 * Way 2: Store in array and do 2 pointer approach.
 * Both traversing inorder wise.
 */
public class PairWithGivenSum {

    public static void main(String[] args) {
        /**
         *          10
         *        5    15
         *      1    12   18
         */
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(1);
        root.right = new Node(15);
        root.right.right = new Node(18);
        root.right.left = new Node(12);
        System.out.println(isPairSum(root, 12, new HashSet<>()));
    }

    private static boolean isPairSum(Node root, int sum, Set<Integer> s) {
        if (root == null) {
            return false;
        }
        if (isPairSum(root.left, sum, s))return true;
        if (s.contains(sum - root.data)) {
            return true;
        }
        s.add(root.data);
        return isPairSum(root.right, sum, s);
    }
}
