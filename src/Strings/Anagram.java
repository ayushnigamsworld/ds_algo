package Strings;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));
    }
    static boolean isAnagram(String s1, String s2) {
        int abcd[] = new int[26];
        for (int i=0; i< s1.length(); i++) {
            abcd[s1.charAt(i) - 97]++;
            abcd[s2.charAt(i) - 97] --;
        }
        for (int i=0; i< s1.length(); i++) {
            if (abcd[s1.charAt(i) - 97] !=0) {
                return false;
            }
        }
        return true;
    }
}
