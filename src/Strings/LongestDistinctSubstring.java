package Strings;

import java.util.Arrays;

public class LongestDistinctSubstring {

    public static void main(String[] args) {
        System.out.println(longestsubstring("abaacdbab"));
    }

    static int longestsubstring(String str) {
        int resL = -1;
        String res = "";
        int i=0;
        while ( i<str.length()) {
            int conc = res.indexOf(str.charAt(i));
            res += str.charAt(i);
            if (conc != -1) {
                res = (conc == res.length()-1) ? "" : res.substring(conc+1);
            }
            resL = Math.max(resL, res.length());
            i++;
        }
        return resL;
    }
}
