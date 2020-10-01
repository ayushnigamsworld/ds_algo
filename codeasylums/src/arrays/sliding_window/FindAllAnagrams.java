package arrays.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        String str = "abab";
        String patt = "ab";
        findAnagrams(str, patt);
    }

    /**
     * Algo:
     * Use Sliding Window.
     * Start =0 , End = len(pattern) - 1
     * 1. Count frequency of characters of pattern, by storing in 26 length arr. A1
     * 2. Count frequency of chars in current window of element in 26 length arr. A2
     * 3. Compare all 26 characters. O(1)
     * 4. Increase count of next element (End++) in A2
     * 5. Decrease count of first element (Start) in A1 then do Start ++
     * 6. The window is shifted,
     *       Repeat from 3 again. O(n)
     *  O(n)
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int start = 0;
        int end = p.length() - 1;
        int count[] = buildCountArr(p);
        int temp[] = new int[26];
        for (int i=start; i<=end; i++) {
            temp[s.charAt(i) - 97]++;
        }
        while (start < s.length() && end < s.length()) {
            boolean res = match(count, temp);
            if (res) {
                result.add(start);
            }
            end++;
            if (end < s.length()) {
                temp[s.charAt(end) - 97]++;
            }
            temp[s.charAt(start) - 97]--;
            start++;
        }
        return result;
    }

    private static int[] buildCountArr(String p) {
        int count[] = new int[26];
        for (int i=0; i<p.length(); i++) {
            count[p.charAt(i) - 97]++;
        }
        return count;
    }

    private static boolean match(int orig[], int temp[]) {
        boolean res = true;
        for (int i=0; i<26; i++) {
            if ( orig[i] != temp[i] ) {
                res = false;
                break;
            }
        }
        return res;
    }
}
