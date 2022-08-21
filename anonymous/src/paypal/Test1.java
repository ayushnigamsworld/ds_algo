package paypal;

import java.util.Arrays;

/**
 * String :

   bcdgthlbcpqur. —> output : length : 11 (dgthlbcpqur)

   Abcdefgab.     —> output : length : 7     (Abcdefg)



 */
public class Test1 {

    public static void main(String[] args) {
        int res = longestSubstringWithoutRepeating("bcbcbcabcd");
        System.out.println(res);
    }

    public static int longestSubstringWithoutRepeating(String inp) {
        int n = inp.length();
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int max = 1;

        int cache[] = new int[26];
        Arrays.fill(cache, -1);
        cache[inp.charAt(0) - 'a'] = 0;
        for (int index = 1; index<n; index++) {
            char currentChar = inp.charAt(index);
            int existingIndex = cache[currentChar - 'a'];
            if (existingIndex != -1) {
                start = existingIndex + 1;
            }
            max = Math.max(index - start + 1, max);
            cache[currentChar - 'a'] = index;
        }

        return max;
    }
}
