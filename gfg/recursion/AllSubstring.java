package recursion;

public class AllSubstring {

    public static void main(String[] args) {
        printAllSubset("ABC", "", 0);
    }

    private static void printAllSubset(String str, String s, int n) {

        if (n == str.length()) {
            // Work done on the leaf of the recursion tree.
            System.out.println(s);
            return;
        }
        printAllSubset(str, s + str.charAt(n), n+1);
        printAllSubset(str, s, n+1);
    }
}
