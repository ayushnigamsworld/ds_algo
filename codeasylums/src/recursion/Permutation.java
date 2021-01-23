package recursion;

public class Permutation {

    public static void main(String[] args) {
        String str = "abc";
        // permutate("", str);
        permutateBacktrack(str, 0);
    }

    private static void permutate(String current, String remaining) {
        // Base Case: when remaining string is empty.
        if (remaining.length() == 0) {
            System.out.println(current);
            return;
        }
        // removing 1 character from remaining and adding it to current
        // need to try this with all the characters.
        for (int i=0; i<remaining.length(); i++) {
            permutate(current + remaining.charAt(i), removeCharacter(remaining, i));
        }
    }

    private static String removeCharacter(String str, int removeIndex) {
        return new StringBuilder(str).deleteCharAt(removeIndex).toString();
    }

    private static void permutateBacktrack(String str, int start) {
        if (start == str.length() - 1) {
            System.out.println("Reached final character, thus Printing: "+str);
            return;
        }
        for (int i = start; i< str.length(); i++) {
            System.out.println("Swapping First "+ str.charAt(start) + " and "+ str.charAt(i));
            str = swap(str, start, i);
            System.out.println("Swapped: "+ str);
            System.out.println("Recursive call with start "+ (start + 1));
            permutateBacktrack(str, start + 1);
            System.out.println("Swapping BackTracking "+ str.charAt(start) + " and "+ str.charAt(i));
            str = swap(str, start, i);
            System.out.println("Backtrack swapped: "+ str);
        }
    }

    private static String swap(String str, int a, int b) {
        char c[] = str.toCharArray();
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
        return String.valueOf(c);
    }
}
