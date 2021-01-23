package recursion;

public class MySubset {

    public static void main(String[] args) {
        subset("abc", "", 0);
    }

    private static void subset(String str, String temp, int index) {
        if (index == str.length()) {
            System.out.println(temp);
            return;
        }
        subset(str, temp, index + 1);
        subset(str, temp + str.charAt(index), index + 1);
    }
}
