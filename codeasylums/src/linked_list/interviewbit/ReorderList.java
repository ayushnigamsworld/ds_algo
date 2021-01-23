package linked_list.interviewbit;

import linked_list.LinkedList;
import linked_list.Node;

public class ReorderList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next = new Node(6);
        linkedList.head.next.next.next.next.next.next = new Node(7);
        linkedList.head.next.next.next.next.next.next.next = new Node(8);
        reorder(linkedList.head);
    }

    private static Node reorder(Node head) {
        Node temp = head;
        Node mid = findMid(temp);
        Node newMid = reverse(mid.next, null);
        mid.next = null;
        while (temp != null && newMid != null) {
            Node temp2 = temp.next;
            temp.next = newMid;
            Node newMid2 = newMid.next;
            newMid.next = temp2;
            temp = temp2;
            newMid = newMid2;
        }
        return head;
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverse(Node head, Node prev) {
        Node temp = head;
        while (temp != null) {
            Node current = temp;
            temp = current.next;
            current.next = prev;
            prev = current;
        }
        head = prev;
        return head;
    }
}
