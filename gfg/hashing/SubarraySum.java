package hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraySum {
    public static void main(String[] args) {
        int arr[] = {5, 3, 8, -2, 8, 10};
        //           5, 8, 16, 14, 22, 32
        subarrsum(arr, 11);
    }

    static void subarrsum(int[] arr, int sum) {

        int temp = 0;
        Set<Integer> hs = new HashSet<>();
        int prefix[] = new int[arr.length];
        for (int i=0; i< arr.length; i++) {
            temp += arr[i];
            prefix[i] = temp;
            hs.add(temp);
        }
        for (int i=0; i< prefix.length; i++) {
            if (prefix[i] >= sum) {
                if (hs.contains(prefix[i] - sum)) {
                    System.out.println("Yes");
                }
            }
        }
    }
}
