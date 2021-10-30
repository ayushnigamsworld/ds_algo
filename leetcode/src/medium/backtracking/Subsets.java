package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        List<List<Integer>> finalRes = new ArrayList<>();
        int[] input = new int[]{1, 2, 3};
        // combinations(input, 0, new ArrayList<>(), finalRes);

//        for (int length=0; length<=input.length; length++) {
//            combinationBacktrack(input, 0, length, new ArrayList<>(), finalRes);
//        }
        System.out.println('a' + "" + 'b');
        combinationLexicographicBinary(input, finalRes);
        System.out.println(finalRes);
    }

    private static void combinations(int[] arr, int i, List<Integer> current, List<List<Integer>> finalResult) {
        if (i == arr.length) {
            finalResult.add(current);
            return;
        }

        combinations(arr, i+1, current, finalResult);
        List<Integer> l = new ArrayList<>(current);
        l.add(arr[i]);
        combinations(arr, i+1, l, finalResult);
    }

    private static void combinationBacktrack(int[] arr, int start, int length, List<Integer> current, List<List<Integer>> finalResult) {
        if (current.size() == length) {
            finalResult.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<arr.length; i++) {
            current.add(arr[i]);
            combinationBacktrack(arr, i + 1, length, current, finalResult);
            current.remove(current.size()-1);
        }
    }

    private static void combinationLexicographicBinary(int[] arr, List<List<Integer>> finalResult) {
        int n = arr.length;
        for (int current = (int)Math.pow(2, n+1) - 1; current >= (int)Math.pow(2, n); current--) {
            String binary = Integer.toBinaryString(current).substring(1);
            List<Integer> result = new ArrayList<>();
            for (int index = 0; index < n; index ++) {
                char currentBit = binary.charAt(index);
                if (currentBit == '1') {
                    result.add(arr[index]);
                }
            }
            finalResult.add(result);
        }
    }
}

// padded representation of numbers 0 to 2^n
class BinaryRepresentation {
    public static void main(String[] args) {
        int n = 4;
        List<String> result = new ArrayList<>();
        for (int current = (int)Math.pow(2, n); current < (int)Math.pow(2, n+1); current ++) {
            result.add(Integer.toBinaryString(current).substring(1));
        }
        System.out.println(result);
    }
}
