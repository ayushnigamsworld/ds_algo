package linked_list.Oct10th;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static Map<Integer, Node> storage = new HashMap<>();
    private static MyDoublyLinkedList lruList = new MyDoublyLinkedList();
    private static LRUCache lruCache = new LRUCache();
    private int capacity = 3;
    private LRUCache() {
    }

    public static LRUCache getInstance() {
        return lruCache;
    }

    public void put(Integer item) {
        if (storage.containsKey(item)) {
            Node toShift = storage.get(item);
            Node prev = toShift.prev;
            prev.next = toShift.next;
            if (toShift.next != null) {
                toShift.next.prev = prev;
            }
            toShift.next = lruList.head;
            lruList.head.prev = toShift;
            lruList.head = toShift;
        } else {
            Node newNode = new Node(item);
            if (lruList.getSize() < capacity) {
                lruList.addToHead(item);
            } else {
                lruList.removeFromEnd();
                lruList.addToHead(item);
            }
            storage.put(item, new Node(item));
        }
    }
}
