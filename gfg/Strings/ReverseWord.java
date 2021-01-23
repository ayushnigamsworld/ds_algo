package Strings;

public class ReverseWord {
    public static void main(String[] args) {
        reverseWordInSentence("iuu love pussy");
    }
    static void reverseWordInSentence(String s) {
        char c[] = s.toCharArray();
        for (int i=0; i<s.length()/2; i++) {
            char temp = c[i];
            c[i] = c[s.length()-1-i];
            c[s.length()-1-i] = temp;
        }
        int start =0;
        int end = 0;
        while (start < c.length && end < c.length) {
            while ((end+1) < c.length && c[end+1] != ' ') {
                end++;
            }
            reverse(c, start, end);
            end += 2;
            start = end;
        }
        System.out.println(new String(c));
    }

    private static void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
}
