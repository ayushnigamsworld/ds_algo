package aa;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNonRepeating {


    public static void main(String[] args) {
        System.out.println(longestSubstringNonRepeating("pwwkew"));
    }

    /**
     *
     * pwwkew
     * 012345
     *
     *
     * Time complexity: O(n)
     * Space complexity: O(n) -> O(1) array of 126 characters..
     * @param str
     * @return
     */
    private static int longestSubstringNonRepeating(String str) {
        if (str == null) {
            str = "";
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int result = 0;
        int s = str.length();

        Map<Character, Integer> cache = new HashMap<>();  // can use array as well
        int start = 0;
        for (int i=0; i<s; i++) {
            char current = str.charAt(i);
            if (cache.containsKey(current)) {
                int newStart = cache.get(current);
                start = newStart + 1;
            }
            cache.put(current, i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
