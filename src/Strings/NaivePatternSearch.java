package Strings;

public class NaivePatternSearch {
    public static void main(String[] args) {
        naivePatternSearch("AAAAA", "AAA");
    }

    static void naivePatternSearch(String str, String pat) {
        for (int i=0; i< str.length(); i++) {
            int p = i;
            while (p< str.length() && (p-i)< pat.length() && str.charAt(p) == pat.charAt(p-i)) {
                p++;
            }
            if (p-i == pat.length()) {
                System.out.println(" Index "+ i);
            }
        }
    }
}
