package verticalMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class ClubAnagramsLexicographically {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("bat");
        input.add("ate");
        input.add("tab");
        input.add("rac");
        input.add("eat");
        input.add("tae");
        input.add("car");
        input(input);
    }

    private static void input(List<String> list) {

        Map<Map<Character, Integer>, TreeSet<String>> cache = new HashMap<>();
        for (String str: list) {
            Map<Character, Integer> generatedCache = generate(str);
            TreeSet<String> internalList = cache.getOrDefault(generatedCache, new TreeSet<>());
            if (cache.containsKey(generatedCache)) {
                internalList.add(str);
                cache.put(generatedCache, internalList);
            } else {
                cache.put(generatedCache, internalList);
            }
            internalList.add(str);
        }

        System.out.println(cache.values());

        Collection<TreeSet<String>> collectionList = cache.values();
        List<TreeSet<String>> listlist = new ArrayList<>();
        listlist.addAll(collectionList);
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i=0; i<collectionList.size(); i++) {
            treeMap.put(listlist.get(i).first(), i);
        }
        for (String str: treeMap.keySet()) {
            int index = treeMap.get(str);
            System.out.println(listlist.get(index));
        }
    }

    private static Map<Character, Integer> generate(String str) {
        Map<Character, Integer> cache = new HashMap<>();
        int size = str.length();
        for (int i=0; i<size; i++) {
            char current = str.charAt(i);
            cache.put(current, cache.getOrDefault(current, 0) + 1);
        }
        return cache;
    }
}


