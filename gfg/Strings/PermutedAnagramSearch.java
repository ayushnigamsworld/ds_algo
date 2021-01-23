package Strings;

public class PermutedAnagramSearch {

    public static void main(String[] args) {
        System.out.println(permutedAnagramSearch("geeksforgeeks", "feog"));
        //                                            0123456789012        0123
    }

    /**
     * TODO: Optimized using sliding window
     * @param str
     * @param p
     * @return
     */
    static boolean permutedAnagramSearch(String str, String p) {
        int i=0;
        while (i<=str.length()-p.length()) {
            int j = i + p.length() - 1;
            if (isAnagram(i, j, str, p)) return true;
            i++;
        }
        return false;
    }

    /**
     * TODO: Optimize this to 2 loops.
     * @param start
     * @param end
     * @param s
     * @param p
     * @return
     */
    private static boolean isAnagram(int start, int end, String s, String p) {
        int abcd[] = new int[26];
        for (int i=0; i< p.length(); i++) {
            abcd[p.charAt(i) - 97]++;
        }
        for (int i=start; i<=end; i++) {
            abcd[s.charAt(i) - 97]--;
        }
        for (int i=0; i< 26; i++) {
            if (abcd[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
