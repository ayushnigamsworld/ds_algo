package arrays.sliding_window;

import java.util.*;

public class SubstringConcatenationAllWords {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String words[] = {"word","good","best","word"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int fixed = words[0].length();
        int fixedCnt = words.length;
        int start = 0;
        int end = fixed * fixedCnt - 1;
        while (start < s.length() && end < s.length()) {
            Map<String, Integer> hashMap = buildMap(words);
            int res = checkIfGood(s, start, end, fixed, hashMap);
            if (res != -1) {
                result.add(res);
            }
            start ++;
            end++;
        }
        return result;
    }

    private static int checkIfGood(String s, int start, int end, int fixed, Map<String, Integer> hashMap) {
        int temp = start;
        while (start <= end) {
            String toCheck = s.substring(start, start + fixed);
            if (hashMap.containsKey(toCheck)) {
                start += fixed;
                int tempV = hashMap.get(toCheck);
                hashMap.put(toCheck, tempV - 1);
                if (tempV < 0) {
                    break;
                }
            } else {
                return -1;
            }
        }
        Collection<Integer> ls = hashMap.values();
        Optional<Integer> optionalInteger = ls.stream().filter( k -> k != 0).findFirst();
        if (optionalInteger.isPresent()) {
            return -1;
        }
        return temp;
    }

    private static Map<String, Integer> buildMap(String[] words) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String a: words) {
            if (hashMap.containsKey(a)) {
                int temp = hashMap.get(a);
                hashMap.put(a, temp + 1);

            } else {
                hashMap.put(a, 1);
            }
        }
        return hashMap;
    }
}
