package Strings;

public class CheckForRotation {
    public static void main(String[] args) {
        System.out.println(checkIfRotationPossible2("ABAB", "AB"));
    }

    static boolean checkIfRotationPossible(String s1, String s2) {
        int i=0;
        while (s1.charAt(i) != s2.charAt(0)) {
            i++;
        }
        int k=0;
        while (k < s2.length() && s1.charAt(i) == s2.charAt(k)) {
            i = (i + 1) % s1.length();
            k++;
        }
        if (k == s2.length()) {
            return true;
        }
        return false;
    }

    static boolean checkIfRotationPossible2(String s1, String s2) {
        s1 += s1;
        return s1.indexOf(s2) != -1;
    }
}
