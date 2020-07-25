package Strings;

/**'
 * TODO: LPS of KMP Algo.
 */
public class LpsArrForString {

    public static void main(String[] args) {
        lps("abacabad");
        //      00101230
    }
    static void lps(String s) {
        char c[] = s.toCharArray();
        int lps[] = new int[s.length()];
        for (int i=0; i<c.length; i++) {

        }
    }

    static String[] properPrefix(String s) {
        String[] prefixArr = new String[s.length() - 1];
        prefixArr[0] = "";
        String temp = "";
        for (int i=0; i< s.length(); i++) {
            prefixArr[i] = temp;
            temp += s.charAt(i);
        }
        return prefixArr;
    }
}
