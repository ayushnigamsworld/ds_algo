package glider.Yoh;

public class HelperFunctionOutput {

    private static int count = 0;
    public static void main(String[] args) {
        helper("abcd", "");
        System.out.println(count);
    }

    static void helper(String str1, String str2) {
        if (str1.length() == 0) {
            count++;
            System.out.println(str2);
        } else {
            for (int i=0; i<str1.length(); i++) {
                char current = str1.charAt(i);
                String currentStr1 = str1.substring(0, i) + str1.substring(i + 1);
                String currentStr2 = str2 + current;
                helper(currentStr1, currentStr2);
            }
        }
    }
}
