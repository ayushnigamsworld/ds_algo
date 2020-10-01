package linked_list;

public class Josephus {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.head.next = new Node(2, null);
        head.head.next.next = new Node(3, null);
        head.head.next.next.next = new Node(4, null);
        head.head.next.next.next.next = new Node(5, null);
        head.head.next.next.next.next.next = new Node(6, null);
        head.head.next.next.next.next.next.next = new Node(7, null);
        head.head.next.next.next.next.next.next.next = head.head;
        killKth(head.head, 2);
    }

    private static void killKth(Node head, int k) {
        Node temp = head;
        while (temp.next != temp) {
            int p = k;
            while (p != 1) {
                temp = temp.next;
                p--;
            }
            Node kill = temp.next;
            temp.next = temp.next.next;
            kill.next = null;
            temp = temp.next;
        }
    }
}
