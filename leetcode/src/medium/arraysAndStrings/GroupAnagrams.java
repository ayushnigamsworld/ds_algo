package medium.arraysAndStrings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String strs[] = new String[]{"eat","tea","tan","ate","nat","bat"};

        Map<String, List<String>> cache = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            String original = strs[i];
            char[] current = strs[i].toCharArray();
            Arrays.sort(current);
            String sorted = new String(current);
            if (cache.containsKey(sorted)) {
                List<String> list = cache.get(sorted);
                list.add(original);
                cache.put(sorted, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(original);
                cache.put(sorted, list);
            }
        }
        System.out.println(new ArrayList<>(cache.values()));
    }
}
