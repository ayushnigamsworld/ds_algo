package glider.WalmartPlus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    private void solve(int capacity, List<String> ar) {
        List<Integer> result = new ArrayList<>();
        LRUCache lruCache = new LRUCache(capacity);
        for (String current : ar) {
            String[] token = current.split(",");
            String op = token[0];
            int key = Integer.parseInt(token[1]);
            if (op.equals("GET")) {
                result.add(lruCache.get(key));
            } else {
                int val = Integer.parseInt(token[2]);
                lruCache.put(key, val);
            }
        }

    }

    private Map<Integer, Integer> mp;
    private int capacity;

    LRUCache(int s) {
        this.capacity = s;
        this.mp = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        int val = mp.get(key);
        mp.remove(key);
        mp.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (mp.size() == this.capacity) {
            mp.remove(mp.entrySet().iterator().next().getKey());
        }
        mp.put(key, value);
    }
}
