package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftmostNonRepeating {
    public static void main(String[] args) {
        System.out.println(leftmostNonRepeating("geeksforgeeks"));
        //                                          0123456789012
    }

    /**
     * most optimized single traversal . had to see
     * @param s
     * @return
     */
    static int leftmostNonRepeating(String s) {
        int abcd[] = new int[26];
        int res = Integer.MAX_VALUE;
        Arrays.fill(abcd, -1);
        // storing all non-repeating
        for (int i=0; i<s.length(); i++) {
            if (abcd[s.charAt(i) - 97] == -1) {
                // first occurence. store its index
                abcd[s.charAt(i) - 97] = i;
            } else {
                // mark repeated
                abcd[s.charAt(i) - 97] = -100; // anything which is not -1 & cant be index
            }
        }

        // finding min index
        for (int a: abcd) {
            if (a > 0) {
                res = Math.min(res, a);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
