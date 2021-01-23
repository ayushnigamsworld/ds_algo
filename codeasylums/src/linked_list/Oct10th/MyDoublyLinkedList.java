package linked_list.Oct10th;

public class MyDoublyLinkedList {
    Node head;
    Node last;
    private int size = 0;
    MyDoublyLinkedList() {
    }
    MyDoublyLinkedList(Node head) {
        this.head = head;
    }

    /**
     * If node to be deleted is part of LL,
     * We can do both addition and deletion in O(1) time.
     * Code below traverses thus O(n), but actually .......
     * @param node
     * @param valueToInsert
     */
    public void add(Node node, int valueToInsert) {
        Node toAdd = new Node(valueToInsert);
        if (head == null) {
            head = new Node(valueToInsert);
        } else if (node == null) {
            toAdd.next = head;
            head.prev = toAdd;
            head = toAdd;
        } else {
            Node temp = head;
            while (temp != node) {
                temp = temp.next;
            }
            Node tempNext = temp.next;
            temp.next = toAdd;
            toAdd.prev = temp;
            toAdd.next = tempNext;
            if (tempNext != null) {
                tempNext.prev = toAdd;
            }
        }
    }

    public void remove(int value) {
        if (head == null) {
            // throw new Error();
        } else if (head.data == value) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        Node toRemove = temp.next;
        temp.next = toRemove.next;
        if (toRemove.next != null) {
            toRemove.next.prev = temp;
        }
        toRemove.next = null;
        toRemove.prev = null;
    }

    public void addToHead(int value) {
        Node temp = new Node(value);
        temp.next = head;
        head.prev = temp;
        head = temp;
        if (last == null) {
            last = head;
        }
        size++;
    }

    public int removeFromEnd() {
        int toRemove = last.data;
        Node secondLast = last.prev;
        secondLast.next = null;
        last = secondLast;
        size--;
        return toRemove;
    }

    public int getSize() {
        return this.size;
    }
}
class Node {
    Integer data;
    Node prev;
    Node next;
    Node (Integer data) {
        this.data = data;
    }
    Node (Integer data, Node prev, Node next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class UseMyDoublyLinkedList {
    public static void main(String[] args) {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList();
        myDoublyLinkedList.head = new Node(1);
        myDoublyLinkedList.add(null, 0);
        myDoublyLinkedList.head.next = new Node(2, myDoublyLinkedList.head, null);
        myDoublyLinkedList.head.next.next = new Node(3, myDoublyLinkedList.head.next, null);
        myDoublyLinkedList.add(myDoublyLinkedList.head.next, 4);
        printAll(myDoublyLinkedList.head);
        myDoublyLinkedList.remove(4);
        printAll(myDoublyLinkedList.head);
    }

    private static void printAll(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
