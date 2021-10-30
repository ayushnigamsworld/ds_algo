package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private static List<List<Character>> res = new ArrayList<>();
    public static void main(String[] args) {
        char[] c = new char[]{'a', 'b', 'c'};
         // permutateBackTrack(c, 0, c.length - 1);
         permutateLoop(c, new ArrayList<>());
    }

    private static void permutateLoop(char[] arr, List<Character> result) {
        if (arr.length == 0) {
            System.out.println(result);
            return;
        }

        for (int i=0; i< arr.length; i++) {
            char c = arr[i];
            // result.add(c);
            char[] sliced = slice(arr, i);
            List<Character> temp = new ArrayList<>(result);
            temp.add(c);
            permutateLoop(sliced, temp);
        }
    }

    private static char[] slice(char[] arr, int index) {
        char[] res = new char[arr.length - 1];
        for (int i=0; i<index; i++) {
            res[i] = arr[i];
        }
        int k = index;
        for (int i=index+1; i<arr.length; i++) {
            res[k] = arr[i];
            k++;
        }
        return res;
    }

    private static void permutateBackTrack(char[] str, int left, int right) {
        if (left == right) {
            System.out.println(str);
            return;
        }
        for (int i=left; i<= right; i++) {
            swap(str, i, left);
            permutateBackTrack(str, left + 1, right);
            swap(str, i, left);
        }
    }

    private static void swap(char[] str, int l, int r) {
        char temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}
