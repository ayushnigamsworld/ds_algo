package BST.selfBalancingBST;

import BST.Node;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Design data structure which:
 * Search
 * Insert
 * Delete
 * K-th smallest
 * in Log(h) time.
 */

/**
 * Best solution:
 * Augmented BST (Modified Node)
 */
public class KthSmallest {

    private static TreeSet<Integer> treeSet = new TreeSet<>();
    private static Integer kthSmallest = null;

    /**
     * Best solution Not able to do.
     * By keeping count of no. of nodes on left of current node.
     * Now we can simply know how to find Kth smallest by following simple rules:
     * if kth = lCount + 1
     *   return root.
     * else if kth > lCount
     *   recurse root.left
     * else
     *   lCount = kth - lCount - 1
     *   recurse root.right
     * @param
     */
    class Node {
        int data;
        Node left;
        Node right;
        int lCount; // Keeping track of No. of nodes on left side of current node.
    }

    public void insert(Integer a) {
        treeSet.add(a);
        if (treeSet.size() <= 3 || (kthSmallest != null && a < kthSmallest)) {
            findKthSmallest(3, true);
        }
    }

    public Boolean search(Integer a) {
        return treeSet.contains(a);
    }

    public void delete(Integer a) {
        treeSet.remove(a);
        if (a <= kthSmallest) {
            findKthSmallest(3, false);
        }
    }

    /*
      Naive
    public Integer findKthSmallest(int k) {
        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext() && k > 1) {
            it.next();
            k--;
        }
        return it.next();
    }*/

    /**
     * Mine
     * @param k
     * @param isInsert
     * @return
     */
    private Integer findKthSmallest(Integer k, Boolean isInsert) {
        if (treeSet.size() < k) {
           kthSmallest = null;
        }else if (treeSet.size() == k) {
            kthSmallest = treeSet.last();
        } else {
            if (isInsert) kthSmallest = treeSet.floor(kthSmallest - 1);
            if (!isInsert) kthSmallest = treeSet.ceiling(kthSmallest + 1);
        }
        return kthSmallest;
    }

    public Integer getKthSmallest() {
        return kthSmallest;
    }
}

class UseKthSmallest {
    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        kthSmallest.insert(10);
        kthSmallest.insert(5);
        kthSmallest.insert(15);
        kthSmallest.insert(20);
        kthSmallest.insert(2);
        System.out.println(kthSmallest.getKthSmallest());
        kthSmallest.insert(1);
        System.out.println(kthSmallest.getKthSmallest());
        kthSmallest.delete(2);
        System.out.println(kthSmallest.getKthSmallest());
    }
}
