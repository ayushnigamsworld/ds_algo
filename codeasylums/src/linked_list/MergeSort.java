package linked_list;

public class MergeSort {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(9);
        linkedList.head.next = new Node(1);
        linkedList.head.next.next = new Node(8);
        linkedList.head.next.next.next = new Node(5);
        linkedList.head.next.next.next.next = new Node(3);
        linkedList.head.next.next.next.next.next = new Node(2);
        Node sorted = mergeSort(linkedList.head);
        System.out.println(sorted);
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = findMid(head);
        Node midNext = midNode.next;
        midNode.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(midNext);
        Node sorted = mergeRecursion(left, right);
        return sorted;
    }

    private static Node findMid(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            temp = temp.next;
            fast = fast.next.next;
        }
        return temp;
    }

    private static Node merge(Node left, Node right) {
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node temp1 = left;
        Node temp2 = right;
        Node result = null;
        if (left.data <= right.data) {
            result = left;
        } else {
            result = right;
        }
        Node resultHead = result;
        while (temp1 != null && temp2 != null) {
            if (left.data <= right.data) {
                result.next = left;
                left = left.next;
            } else {
                result.next = right;
                right = right.next;
            }
            result = result.next;
        }
        if (temp1 != null) {
            result.next = temp1;
        } else {
            result.next = temp2;
        }
        return resultHead;
    }

    private static Node mergeRecursion(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result = null;
        if (left.data <= right.data) {
            result = left;
            result.next = mergeRecursion(left.next, right);
        } else {
            result = right;
            result.next = mergeRecursion(left, right.next);
        }
        return result;
    }
}
