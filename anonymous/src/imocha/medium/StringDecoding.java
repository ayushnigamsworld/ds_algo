package imocha.medium;

public class StringDecoding {

    public static void main(String[] args) {
        String S = "abcde";
        String result = "";
        StringBuilder ss = new StringBuilder();
        ss.append(S);
        ss.reverse();
        String orig = ss.toString();
        for (int i=0; i<orig.length(); i++) {
            char current = orig.charAt(i);
            if (current != 'a') {
                current = (char)(current - 1);
            } else {
                current = 'z';
            }
            result += current;
        }
        System.out.println(result);
    }
}
