package jubilant;

public class MyHashMap {

    private MyLinkedList[] arr;
    private Integer size;
    private Integer capacity;

    MyHashMap(int capacity) {
        this.capacity = capacity;
        arr = new MyLinkedList[capacity];
    }


    public void put(String key, String value) {
        int hashCode = this.hashCode(key);
        MyLinkedList existing = arr[hashCode];
        if (existing != null) {
            existing.add(new Pair(key, value));
        } else {
            MyLinkedList temp = new MyLinkedList();
            temp.add(new Pair(key, value));
            arr[hashCode] = temp;
        }
    }

    public String get(String key) {
        int hashCode = this.hashCode(key);
        MyLinkedList existing = arr[hashCode];
        if (existing != null) {
            return existing.findFromKey(key);
        }
        return null; // throw exception
    }

    private int hashCode(String key) {
        // always generates a good hash.
        return 1;
    }
}

class LinkedListNode {
    Pair value;
    LinkedListNode next;

    LinkedListNode(Pair v) {
        this.value = v;
    }
}

class MyLinkedList {
    LinkedListNode head;

    public void add(Pair element) {
        if (head == null) {
            head = new LinkedListNode(element);
            head.next = null;
        } else {
            LinkedListNode temp = head;
            head.next = new LinkedListNode(element);
            head = temp;
        }
    }

    public boolean search(Pair element) {
        if (head == null) {
            return false;
        }
        LinkedListNode temp = head;
        while (temp != null) {
            if (temp.value.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public String findFromKey(String key) {
        if (head == null) {
            return null;
        }
        LinkedListNode temp = head;
        while (temp != null) {
            if (temp.value.key.equals(key)) {
                return temp.value.value;
            }
            temp = temp.next;
        }
        return null;
    }
}

class Pair {
    String key;
    String value;
    Pair(String k, String v) {
        this.key = k;
        this.value = v;
    }
}
