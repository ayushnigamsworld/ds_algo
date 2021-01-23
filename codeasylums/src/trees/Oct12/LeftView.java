package trees.Oct12;

import java.util.*;

public class LeftView {
    private static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>(1);
        myTree.root.left = new Node(2);
        myTree.root.right = new Node(3);
        myTree.root.left.left = new Node(4);
        myTree.root.left.right = new Node(5);
        myTree.root.right.right = new Node(6);
        myTree.root.right.right.right = new Node(7);
        leftView(myTree.root, 0);
    }

    /**
     * Do it with single count
     * 1. Single global variable.
     * 2. Without any shared memory.
     * @param root
     * @param level
     */
    private static void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (!set.contains(level)) {
            System.out.println(root.data);
            set.add(level);
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    /**
     * Maintain global variable for knowing till what height explored.
     * @param root
     * @param level
     */
    private static void leftViewGlobal(Node root, int level) {

    }

    /**
     *
     def leftview(self, currentDepth=1, exploredDepth=0):
         if exploredDepth < currentDepth:
             exploredDepth += 1
             print(self.value)

         if self.left != None:
            exploredDepth = self.left.leftview(currentDepth + 1, exploredDepth)

         if self.right != None:
            exploredDepth = self.right.leftview(currentDepth + 1, exploredDepth)

         return exploredDepth
     * @param root
     * @param currentLevel
     * @param exploredLevel
     * @return
     */
    private static int leftViewWithoutGlobal(Node root, int currentLevel, int exploredLevel) {
        return -1;
    }
}
