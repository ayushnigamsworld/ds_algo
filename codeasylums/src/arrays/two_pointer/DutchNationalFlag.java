package arrays.two_pointer;

/**
 * Given an array A[] consisting 0s, 1s and 2s.
 * The task is to write a function that sorts the given array.
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * (Dutch national flag problem)
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int input[] = {2, 2, 2, 0, 1, 0, 2, 0, 1, 1, 1, 0, 1, 2, 1, 0, 1};
        dutchFlag(input);
    }

    /**
     * Simply divide the array into 3 portions.
     * First portion will hold all 0s.
     * Second portion will hold all 1s.
     * Third portion will hold all 2s.
     * Use Low, Mid and High
     * Low ---> increments (advocate of 0)
     * High <---- decrements (advocate of 2)
     * Mid behaves same as counter. (advocate of 1.)
     * @param input
     */
    private static void dutchFlag(int input[]) {
        int low = 0;
        int high = input.length -1;
        int mid = 0;
        while (mid <= high) {
            if (input[mid] == 0) {
                swap(input, low, mid);
                low++;

            } else if (input[mid] == 2) {
                swap(input, high, mid);
                high--;

            } else {
                mid++;
            }
        }
        for (int a: input) {
            System.out.print(a + " ");
        }
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
