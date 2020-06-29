package Strings;

public class LeftMostRepeating {
    public static void main(String[] args) {
        System.out.println(leftMostRepeatingChar("ambxcqwrcb"));
        //                                           0123456789
    }
    static int leftMostRepeatingChar(String s) {
        boolean abcd[] = new boolean[26];
        int res = Integer.MAX_VALUE;
        for (int i=s.length()-1; i>0; i--) {
            if (abcd[s.charAt(i) -97]) {
                res = Math.min(res, i);
            } else {
                abcd[s.charAt(i) -97] = true;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res ;
    }
}
