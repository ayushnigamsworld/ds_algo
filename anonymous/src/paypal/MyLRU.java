package paypal;

import java.util.HashMap;
import java.util.Map;

// Algorithm
// Demoable code
// Least Recently Used
// 1 , 2, 3, 5, 6, 1-> evicted and 6 will be inserted, 7, 2will be evicted and 7 will be inserted..
// Storage // Map / Set (hashed data structure)..
// We can keep track of least recently used stuff..
// Brute force:: keep counter, maintain counter, search lru and eliminate and keep new stuff.. O(n)
// Capacity
// Insert update delete at O(1) :: hashDS
// go by convention keep least recently at one end and new items at another end,
// we can quickly remove and add..
// doubly linkedList to remove and add..
// Set -> Map :: value being searched in O(1) and value:: other operations will be done via LL Node
public class MyLRU {

    private Map<Integer, Pair> storage;
    private LLNode head;
    private LLNode tail;
    private int size;
    private int capacity;

    public static void main(String[] args) {
        MyLRU myLRU = new MyLRU();
        myLRU.init(5);
        myLRU.add(1, 2);
        myLRU.add(2, 4);
        myLRU.add(2, 5);
        myLRU.add(3, 6);
        myLRU.search(2);
        myLRU.search(3);
    }

    public void init(int capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    public void add(int k, int v) {
        LLNode newNode = null;
        if (storage.containsKey(k)) {
            Pair existingPair = storage.get(k);
            LLNode existingNode = existingPair.node;
            removeNode(existingNode);
        }
        newNode = addToEndLL(v);
        if (this.size == this.capacity) {
            removeHead();
            storage.remove(k);
        }
        storage.put(k, new Pair(v, newNode));
        this.size++;
    }

    // if not present either throw exception or -1 or something..
    public int search(int k) {
        int res = -1;
        if (storage.containsKey(k)) {
            Pair existingPair = storage.get(k);
            res = existingPair.data;
            LLNode existingNode = existingPair.node;
            removeNode(existingNode);
            storage.put(k, new Pair(res, addToEndLL(res)));
        } else {
           // throw exception or -1 whatever
        }
        return res;
    }

    public void remove(int k) {
        if (storage.containsKey(k)) {
            LLNode existingNode = storage.get(k).node;
            removeNode(existingNode);
            storage.remove(k);
        }
    }

    // another class of LL
    private LLNode addToEndLL(int k) {
        LLNode newNode = new LLNode(k);
        if (tail != null) {
            newNode.prev = tail;
            tail.next = newNode;
        }
        if (head == null) {
            head = newNode;
        }
        tail = newNode;
        this.size--;
        return newNode;
    }

    private void removeNode(LLNode node) {
        LLNode prevNode = node.prev;
        LLNode nextNode = node.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        if (head == node) {
            head = node.next;
        }
        node.next = null;
        node.prev = null;
    }

    private void removeHead() {
        removeNode(this.head);
    }
}



class Pair {
    int data;
    LLNode node;

    Pair(int data, LLNode node) {
        this.data = data;
        this.node = node;
    }
}

// private, getter setter
class LLNode {
    LLNode(int data) {
        this.data = data;
    }
    int data;
    LLNode prev;
    LLNode next;
}


class MyCache {


    private void set(int k, int v) {

    }

    private int get(int k) {
        return 0;
    }


}
