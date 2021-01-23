package recursion;

public class Subsets {
    public static void main(String[] args) {
        subset("", "abc");
    }

    private static void subset(String current, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(current);
            return;
        }
        subset(current, removeCharacter(remaining, 0));
        subset(current + remaining.charAt(0), removeCharacter(remaining, 0));
    }

    private static String removeCharacter(String str, int removeIndex) {
        return new StringBuilder(str).deleteCharAt(removeIndex).toString();
    }
}
