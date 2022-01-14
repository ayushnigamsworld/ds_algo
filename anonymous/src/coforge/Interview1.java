package coforge;

import java.util.*;

public class Interview1 {

    public static void main(String[] args) {
        Interview1 interview1 = new Interview1();
        List<Integer> inp = new ArrayList<>();
        inp.add(2);
        inp.add(4);
        inp.add(2);
        inp.add(2);
        inp.add(4);
        inp.add(2);
        inp.add(6);
        // 6
        interview1.nonRepeating(inp);
    }

    // hashing solution
    // Time O(n) Space O(n)
    private List<Integer> nonRepeating(List<Integer> inp) {
        Map<Integer, Integer> cache = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (Integer current: inp) {
            cache.put(current, cache.getOrDefault(current, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: cache.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        System.out.println(result);
        return result;
    }

    // sort it and then iterate.
    // Time O(nlogn) Space O(1)
}
