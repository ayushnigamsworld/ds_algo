package medium.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepetition {

    public static void main(String[] args) {
        String s = "";
        int start = 0;
        int end = 1;
        Map<Character, Integer> cache = new HashMap<>();
        cache.put(s.charAt(0), 0);
        int len = s.length();
        int res = 0;
        while (start< len && end < len) {
            char current = s.charAt(end);
            if (cache.containsKey(current)) {
                Integer st = cache.get(current);
                if (start <= st) {
                    start = st + 1;
                }
            }
            cache.put(current, end);
            res = Math.max(res, end - start + 1);
            end++;
        }
        noExtraSpace(s);
        // System.out.println(res);
    }

    private static void noExtraSpace(String s) {
        int start = 0;
        int len = s.length();
        int res = 1;
        int end = 1;
        while (end < len) {
            int i = start;
            while (i < end) {
                if (s.charAt(i) == s.charAt(end)) {
                    res = Math.max(res, end - start);
                    start = i + 1;
                }
                i++;
            }
            end++;
        }
        System.out.println(res);
    }
}
