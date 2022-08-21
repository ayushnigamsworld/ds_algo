import java.util.Arrays;

public class LongestNonRepeatingSubstring {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.

     Input: s = "bacabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.
     Input: s = "bbbbb"
     Output: 1
     Explanation: The answer is "b", with the length of 1.
     Input: s = "pwwkew"
     Output: 3
     Explanation: The answer is "wke", with the length of 3.
     Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param args
     */
    public static void main(String[] args) {
        int res = findLongestSubstringWithoutRepeating("pwwkew");
        System.out.println(res);
    }

    // sliding window approach
    // assuming all are lower case alphabets specifically.
    // abcabcbb
    // cache which tells if new incoming character is already there or not
    // rightEnd includeCharacter,
    // leftEnd shift to last repeating character.
    // maintain res which is length of window
    private static int findLongestSubstringWithoutRepeating(String str) {
        // assuming str to be atleast 2 character long
        int start = 0;
        int res = 1;
        int cache[] = new int[26];
        Arrays.fill(cache, -1);

        cache[str.charAt(0) - 'a'] = 0;
        int n = str.length();
        int i = 1;

        while (i < n) {
            if (cache[str.charAt(i) - 'a'] == -1) {
                res = Math.max(res, i - start + 1);
            } else {
                start = cache[str.charAt(i) - 'a'] + 1;
            }
            cache[str.charAt(i) - 'a'] = i;
            i++;
        }
        return res;
    }
}
