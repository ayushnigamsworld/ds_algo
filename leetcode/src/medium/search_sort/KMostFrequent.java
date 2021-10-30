package medium.search_sort;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class KMostFrequent {

    public static void main(String[] args) {
        int inp[] = new int[]{2,1,1,1,2,4,4,3,4,4};
        KMostFrequent kMostFrequent = new KMostFrequent();
        int k = 3;
        int res[] = kMostFrequent.kmostfrequent(inp, k);
        for (int i: res) {
            System.out.println(i);
        }

        res = kMostFrequent.kmostfrequentBucketSorting(inp, k);
        for (int i: res) {
            System.out.println(i);
        }
    }

    public int[] kmostfrequent(int[] inp, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        int[] res = new int[k];
        for (int i=0; i<inp.length; i++) {
            cache.put(inp[i], cache.getOrDefault(inp[i], 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> cache.get(o1) - cache.get(o2));
        for (Integer key: cache.keySet()) {
            heap.offer(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int cnt = 0;
        while (k > 0) {
            res[cnt]= heap.poll();
            k--;
            cnt++;
        }
        return res;
    }

    private int[] kmostfrequentBucketSorting(int[] inp, int k) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i=0; i<inp.length; i++) {
            cache.put(inp[i], cache.getOrDefault(inp[i], 0) + 1);
        }
        List bucket[] = new ArrayList[inp.length];
        for (Integer key: cache.keySet()) {
            int freq = cache.get(key);
            if (bucket[freq] == null) {
                List<Integer> t = new ArrayList<>();
                t.add(key);
                bucket[freq] = t;
            } else {
                bucket[freq].add(key);
            }
        }

        List<Integer> flattened = new ArrayList<>();
        for (List list: bucket) {
            if (list != null) {
                flattened.addAll(list);
            }
        }
        int j = 0;
        int[] res = new int[k];
        while (k > 0) {
            res[j] = flattened.get(flattened.size() - j - 1);
            k--;
            j++;
        }
        return res;
    }
}
