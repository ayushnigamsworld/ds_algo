package hackerrank.teksystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArrQueries {

    public static void main(String[] args) {

        List<Integer> inp = new ArrayList<>();
        inp.add(5);
        inp.add(3);
        inp.add(2);
        inp.add(1);
        inp.add(3);
        reverse(inp, 0, 3);
        System.out.println(inp);
    }

    private static void reverse(List<Integer> inp, int start, int end) {
        while (start < end) {
            int temp = inp.get(start);
            inp.set(start, inp.get(end));
            inp.set(end, temp);
            start++;
            end--;
        }
    }
}
