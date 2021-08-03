package glider.WalmartPlus;

import java.util.ArrayList;
import java.util.List;

public class ShiftZeroToEnd {

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        for (int i=0; i<arr.length; i++) {
            ls.add(arr[i]);
        }
        List<Integer> ll = shiftZero(ls);
        System.out.println(ll);
    }

    private static List<Integer> shiftZero(List<Integer> ls) {
        int nonZeroCount = 0;
        int n = ls.size();
        for (int i=0; i<n; i++) {
            int current = ls.get(i);
            if (current != 0) {
                ls.set(nonZeroCount, current);
                nonZeroCount++;
            }
        }
        while (nonZeroCount < n) {
            ls.set(nonZeroCount, 0);
            nonZeroCount++;
        }
        return ls;
    }
}
