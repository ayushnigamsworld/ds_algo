package hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarraySumZero {

    public static void main(String[] args) {
        int arr[] = {5, 6, -4, -2, 8, 10};
        subarrsum0(arr);
    }

    static void subarrsum0(int[] arr) {

        int temp = 0;
        Set<Integer> hs = new HashSet<>();
        for (int i=0; i< arr.length; i++) {
            temp += arr[i];
            if (hs.contains(temp)) {
                System.out.println("Yes");
                break;
            } else {
                hs.add(temp);
            }
        }
    }
}
