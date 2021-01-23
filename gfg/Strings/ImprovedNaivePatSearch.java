package Strings;

/**
 * For distinct characters of pattern in O(n)
 */
public class ImprovedNaivePatSearch {
    public static void main(String[] args) {
        improvedNaive("ABCABCDABCD", "ABCD");
    }

    static void improvedNaive(String str, String pat) {
        for (int i=0; i< str.length(); i++) {
            System.out.print(" --> "+i);
            int p = i;
            while (p< str.length() && (p-i)< pat.length() && str.charAt(p) == pat.charAt(p-i)) {
                System.out.print(" p--> "+ p);
                p++;
            }
            if (p-i == pat.length()) {
                System.out.println(" Index "+ i);
            }
            i = p-1;
        }
    }
}
