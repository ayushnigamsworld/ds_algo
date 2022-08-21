package paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Input :

 11  12  5  7  10
 1    2    3  4   5

 2 3 4 1

 Output:
 12 , 5
 1 ,  5


 Approach:: Since rotated sorted, find pivot via binary search, and on some careful conditions,
 get the answer for each rpw./

 *
 */
public class Test2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        Integer[] arr = {8, 9, 10, 11, 5, 6, 7};
        Integer[] arr = {2, 3, 4, 1};
        list = Arrays.asList(arr);
        int res = findPivot(list, 0, arr.length-1);
        System.out.println("element "+ arr[res]);
        System.out.println("Index "+ res);
    }

    public List<List<Integer>> findRowWiseMinMax(List<List<Integer>> inp) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    // returns the start i.e. index of lowest element
    private static int findPivot(List<Integer> inp, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low)/2;
        if (mid > 0 && inp.get(mid - 1) > inp.get(mid)) {
            return mid;
        }
        else if (inp.get(low) > inp.get(mid)) {
            return findPivot(inp, low, mid);
        }
        return findPivot(inp, mid, high);
    }
}
