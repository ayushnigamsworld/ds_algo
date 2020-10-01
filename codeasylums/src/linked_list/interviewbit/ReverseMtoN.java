package linked_list.interviewbit;

import linked_list.LinkedList;
import linked_list.Node;

public class ReverseMtoN {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);
        // linkedList.head.next.next.next.next = new Node(5);
        reverseBetween(linkedList.head, 2, 4);
    }

    private static Node reverseBetween(Node A, int B, int C) {
        Node temp = A;
        Node start = A;
        int p = B;
        while (temp != null && p != 1) {
            start = temp;
            temp = temp.next;
            p--;
        }
        if (start.next == null) {
            return A;
        }
        int K = C-B + 1;
        Result result = reverse(temp, K);
        if (result.start != start) {
            start.next = result.last;
            return A;
        } else {
            return result.last;
        }
    }

    private static Result reverse(Node A, int k) {
        Node prev = null;
        Node start = A;
        Node next = A;
        while (next != null && k != 0) {
            Node current = next;
            next = next.next;
            current.next = prev;
            prev = current;
            k--;
        }
        start.next = next;
        Result result = new Result(start, prev);
        return result;
    }
    static class Result {
        Node start;
        Node last;
        Result(Node start, Node last) {
            this.start = start;
            this.last = last;
        }
    }
}
