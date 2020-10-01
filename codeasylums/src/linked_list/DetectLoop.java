package linked_list;

public class DetectLoop {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.head.next = new Node(2, null);
        linkedList.head.next.next = new Node(3, null);
        linkedList.head.next.next.next = new Node(4, null);
        linkedList.head.next.next.next.next = linkedList.head.next;
        detectLoop(linkedList.head);
    }

    /**
     * Carefully right the fast.next = null check on while thing.
     * @param head
     * @return
     */
    private static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Count no of nodes in loop: K,
     * Keep one ptr K distance apart from first.
     * @param head
     */
    private static void removeLoop(Node head) {

    }
}
