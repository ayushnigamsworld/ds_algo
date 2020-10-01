package arrays.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * From Leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating characters.



 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestNonRepeatingSubstring {

    public static void main(String[] args) {
        String s = "abcb";
        int i = s.indexOf('b');
        //System.out.println(s.substring(i+1));
        lengthOfLongestSubstring("dvdf");
    }

    /**
     * Better directly use HashSet
     * @param str
     * @return
     */
    private static int lengthOfLongestSubstring(String str) {
        Set<Character> window = new HashSet<>();
        int start = 0, end = 0;
        int result = 0;
        while(start < str.length() && end < str.length()) {
            Character c = str.charAt(end);
            if (!window.contains(c)) {
                window.add(c);
                end++;
                if (result < (end - start)) {
                    result = (end - start);
                }
            } else {
                window.remove(str.charAt(start));
                start ++;
            }
        }
        return result;
    }

    /** Mine solution:
     *  Farzi ki complexity
     * @param s
     * @return
     */
    /*
    public static int lengthOfLongestSubstring(String s) {
        String resStr = "";
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            Character current = s.charAt(i);
            int repeatIndex = resStr.indexOf(current);
            if (repeatIndex == -1) {
                resStr += current + "";

            } else {
                resStr = resStr.substring(repeatIndex + 1);
                resStr += current + "";
            }
            if (max < resStr.length()) {
                max = resStr.length();
            }
        }
        return max;
    }
    */
}
