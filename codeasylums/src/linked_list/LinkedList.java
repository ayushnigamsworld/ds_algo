package linked_list;

public class LinkedList {

    public Node head;
    public LinkedList(int head) {
        this.head = new Node(head, null);
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.head.next = new Node(2, null);
        head.head.next.next = new Node(3, null);
        head.head.next.next.next = new Node(4, null);
        head.head.next.next.next.next = new Node(5, null);
        head.head.next.next.next.next.next = new Node(6, null);
        head.head.next.next.next.next.next.next = new Node(7, null);
        head.head.next.next.next.next.next.next.next = new Node(8, null);
        head.head.next.next.next.next.next.next.next.next = new Node(9, null);
//        reverse(head.head);
        //reverseRecursion(head.head, null);
        Node a = reverseKtimes(head.head, 3);

        System.out.println(a);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node next = head;
        while (next != null) {
            Node current = next;
            next = current.next;
            current.next = prev;
            prev = current;
        }
        head = prev;
        return head;
    }

    private static Node reverseRecursion(Node head, Node prev) {
        if (head != null) {
            Node current = head;
            head = head.next;
            current.next = prev;
            reverseRecursion(head, current);
        }
        return prev;
    }

    /**
     * NOT ABLE TO DO.
     * @param head
     * @param k
     * @return
     */
    private static Node reverseKtimes(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node next = head;
        int p = k;
        while (next != null && p !=0) {
            Node current = next;
            next = current.next;
            current.next = prev;
            prev = current;
            p--;
        }
        head.next = reverseKtimes(next, k);
        return prev;
    }

    private static Node reverseK(Node head, int k) {
        Node prev = null;
        Node next = head;
        while (next != null && k != 0) {
            Node current = next;
            next = current.next;
            current.next = prev;
            prev = current;
            k--;
        }
        head = next;
        return prev;
    }
}
