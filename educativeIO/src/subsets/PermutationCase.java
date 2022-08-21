package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCase {

    public static void main(String[] args) {
        System.out.println(letterCasePermutations("ab7c"));
    }

    private static List<List<Character>> letterCasePermutations(String input) {
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(input.charAt(0))));
        result.add(new ArrayList<>(Arrays.asList(Character.toUpperCase(input.charAt(0)))));
        for (int i=1; i<input.length(); i++) {
            char currentChar = input.charAt(i);
            List<List<Character>> tempResult = new ArrayList<>();
            for (List<Character> str: result) {
                if (!Character.isAlphabetic(currentChar)) {
                    str.add(currentChar);
                    tempResult.add(str);
                    continue;
                }
                List<Character> tempUpper = new ArrayList<>(str);
                tempUpper.add(currentChar);
                tempResult.add(tempUpper);
                str.add(Character.isUpperCase(currentChar) ?
                        Character.toLowerCase(currentChar) : Character.toUpperCase(currentChar));
                tempResult.add(str);
            }
            result = tempResult;
        }
        return result;
    }
}
