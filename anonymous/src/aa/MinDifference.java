package aa;

import java.util.*;

public class MinDifference {

    public static void main(String[] args) {

    }

    public void findDiff(List<Integer> arr, int n) {
        Collections.sort(arr);
        int nn = arr.size();

        int diff = Integer.MAX_VALUE;

        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < nn - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) < diff) {
                diff = arr.get(i + 1) - arr.get(i);
            }
        }
        cache.addAll(arr);

        for (int i=0; i<nn; i++) {
            if (cache.contains(arr.get(i) + diff)) {
                System.out.println(arr.get(i) + " " + arr.get(i) + diff);
            }
        }

    }
}
