package codility;

// Java implementation of the approach
// https://www.geeksforgeeks.org/find-the-largest-perfect-subtree-in-a-given-binary-tree/
import java.util.*;

public class PerfectBinaryTree
{

    // Node structure of the tree
    static class node
    {
        int data;
        node left;
        node right;
    };

    // To create a new node
    static node newNode(int data)
    {
        node node = new node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    };

    // Structure for return type of
// function findPerfectBinaryTree
    static class returnType
    {

        // To store if sub-tree is perfect or not
        boolean isPerfect;

        // Height of the tree
        int height;

        // Root of biggest perfect sub-tree
        node rootTree;
    };

    // Function to return the biggest
// perfect binary sub-tree
    static returnType findPerfectBinaryTree(node root)
    {

        // Declaring returnType that
        // needs to be returned
        returnType rt = new returnType();

        // If root is null then it is considered as
        // perfect binary tree of height 0
        if (root == null)
        {
            rt.isPerfect = true;
            rt.height = 0;
            rt.rootTree = null;
            return rt;
        }

        // Recursive call for left and right child
        returnType lv = findPerfectBinaryTree(root.left);
        returnType rv = findPerfectBinaryTree(root.right);

        // If both left and right sub-trees are perfect and
        // there height is also same then sub-tree root
        // is also perfect binary subtree with height
        // plus one of its child sub-trees
        if (lv.isPerfect && rv.isPerfect)
        {
            if (lv.height == rv.height) {
                rt.height = lv.height + 1;
            } else if (Math.abs(lv.height - rv.height) == 1){
                rt.height = Math.min(lv.height, rv.height);
            }

            rt.isPerfect = true;
            rt.rootTree = root;
            return rt;
        }

        // Else this sub-tree cannot be a perfect binary tree
        // and simply return the biggest sized perfect sub-tree
        // found till now in the left or right sub-trees
        rt.isPerfect = false;
        rt.height = Math.max(lv.height, rv.height);
        rt.rootTree = (lv.height > rv.height ?
                lv.rootTree : rv.rootTree);
        return rt;
    }

    // Function to print the
// inorder traversal of the tree
    static void inorderPrint(node root)
    {
        if (root != null)
        {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        // Create tree
        node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.right.left = newNode(5);
        root.right.right = newNode(6);
        root.right.left.left = newNode(7);
        root.right.left.right = newNode(8);
        root.right.right.left = newNode(9);
        root.right.right.right = newNode(10);
        root.right.right.right.left = newNode(11);

        // Get the biggest sizes perfect binary sub-tree
        returnType ans = findPerfectBinaryTree(root);

        // Height of the found sub-tree
        int h = ans.height;

        System.out.println("Size : " +
                (Math.pow(2, h) - 1));

        // Print the inorder traversal of the found sub-tree
        System.out.print("Inorder Traversal : ");
        inorderPrint(ans.rootTree);
    }
}

// This code is contributed by 29AjayKumar
