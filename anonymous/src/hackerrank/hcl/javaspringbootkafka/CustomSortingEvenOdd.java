package hackerrank.hcl.javaspringbootkafka;

import java.util.ArrayList;
import java.util.List;

public class CustomSortingEvenOdd {

    public static void main(String[] args) {
        List<Integer> inp = new ArrayList<>();
        inp.add(13);
        inp.add(10);
        inp.add(21);
        inp.add(20);
//        inp.add(6);
        System.out.println(moves(inp));
    }

    public static int moves(List<Integer> inp) {
        int res = 0;
        int start = 0;
        int end = inp.size() - 1;
        while (start < end) {
            int first = inp.get(start);
            int last = inp.get(end);

            if (isEven(first) && isEven(last)) {
                start++;
            } else if (!isEven(first) && isEven(last)) {
                res++;
                start++;
                end--;
            } else {
                start++;
                end--;
            }
        }
        return res;
    }

    private static boolean isEven(int a) {
        return a % 2 == 0;
    }
}
