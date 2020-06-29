package hashing;

import java.util.HashMap;
import java.util.Map;

public class Largestsubarr01 {

    public static void main(String[] args) {
         int arr[] = { 0, 1, 1, 0, 1, 1, 0 };
//        int arr[] = {1, 1, 1};
        System.out.println(longestsubarr01(arr));
    }

    static int longestsubarr01(int arr[]) {
        int res = 0;
        int prefix[] = new int[arr.length];
        for (int i=0; i< arr.length; i++) {
            prefix[i] = arr[i] == 0 ? -1 : 1;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        int temp = 0;
        for (int i=0; i< arr.length; i++) {
            temp += prefix[i];
            prefix[i] = temp;
            if (hm.containsKey(prefix[i])) {
                res = Math.max( i - hm.get(prefix[i]), res);
            } else {
                hm.put(prefix[i], i);
            }
        }
        return res;
    }
}
