package linked_list.interviewbit;

import linked_list.LinkedList;
import linked_list.Node;

/**
 * Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

 For example, given following linked lists :

 5 -> 8 -> 20
 4 -> 11 -> 15
 The merged list should be :

 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeSortedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(5);
        linkedList.head.next.next.next = new Node(8);
        linkedList.head.next.next.next.next = new Node(9);
        LinkedList linkedList2 = new LinkedList(4);
        linkedList2.head.next = new Node(5);
        linkedList2.head.next.next = new Node(6);
        linkedList2.head.next.next.next = new Node(7);
        linkedList2.head.next.next.next.next = new Node(11);
        Node result =mergeSorted(linkedList.head, linkedList2.head);
        System.out.println(result);
    }

    /**
     *  1 -> 2 -> 5 -> 8 -> 9
     *  4 -> 5 -> 6 -> 7 -> 11
     */
    private static Node mergeSorted(Node A, Node B) {
        if (A == null && B == null) {
            return null;
        }
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        Node temp1 = A;
        Node temp2 = B;
        Node merged = null;
        if (temp1.data <= temp2.data) {
            merged = temp1;
            temp1 = temp1.next;
        } else {
            merged = temp2;
            temp2 = temp2.next;
        }
        Node mergedHead = merged;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                merged.next = temp1;
                temp1 = temp1.next;
            } else {
                merged.next = temp2;
                temp2 = temp2.next;
            }
            merged = merged.next;
        }
        while (temp1 != null) {
            merged.next = temp1;
            merged = merged.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            merged.next = temp2;
            merged = merged.next;
            temp2 = temp2.next;
        }
        return mergedHead;
    }

    private static Node mergedSortRecursive(Node left, Node right) {
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result = null;
        if (left.data <= right.data) {
            result = left;
            result.next = mergedSortRecursive(left.next, right);
        } else {
            result = right;
            result.next = mergedSortRecursive(left, right.next);
        }
        return result;
    }
}
