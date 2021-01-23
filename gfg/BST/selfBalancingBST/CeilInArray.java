package BST.selfBalancingBST;

import java.util.TreeSet;

public class CeilInArray {

    public static void main(String[] args) {
        int arr[] = {2, 16, 30, 15, 25, 1};
        int res[] = findCeilEach(arr);
        for (int a: res) {
            System.out.print(a + " ");
        }
    }

    private static int[] findCeilEach(int arr[]) {
        int resArr[] = new int[arr.length];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=0; i< arr.length; i++) {
            Integer res = treeSet.ceiling(arr[i]);
            if (res != null) {
                resArr[i] = res;
            } else {
               resArr[i] = -1;
            }
            treeSet.add(arr[i]);
        }
        return resArr;
    }
}
