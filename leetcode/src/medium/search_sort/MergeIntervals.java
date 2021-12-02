package medium.search_sort;

import medium.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] inp = {{0, 3}, {1, 7}, {5, 6}, {11, 11}};
        int[][] res = new MergeIntervals().merge(inp);
        for (int[] r: res) {
            System.out.print(r[0] + " " + r[1]);
            System.out.println();
        }
    }

    private int[][] merge(int[][] inp) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(inp, Comparator.comparingInt(a -> a[0]));
        boolean noMerge = true;
        for (int i=0; i<inp.length; i++) {
            int[] current = inp[i];
            while (i+1<inp.length && current[1] >= inp[i+1][0]) {
                if (current[1] < inp[i+1][1]) {
                    current[1] = inp[i+1][1];
                }
                i++;
                noMerge = false;
            }
            res.add(current);
        }
        if (noMerge) return inp;
        return res.toArray(new int[res.size()][]);
    }
}
