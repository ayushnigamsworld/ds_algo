package sorting;

public class Bubble {
    public static void main(String[] args) {
        int[] a = bubble(new int[] {0 ,0 ,-1, 2, 2, 2, 2, 2});
        for (int aa: a) {
            System.out.println(aa);
        }
    }

    /**
     * On each normal iteration,
     * we are comparing only 2 elements, and swapping based on their values
     * After each full iteration, reducing the limit till which it needs to iterate.
     * @param arr
     * @return
     */
    private static int[] bubble(int arr[]) {
        int end = arr.length;
        while (end > 1) {
            int ptr1 = 0;
            int ptr2 = 1;
            while (ptr2 < end) {
                if (arr[ptr1] > arr[ptr2]) {
                    swap(arr, ptr1, ptr2);
                }
                ptr1++;
                ptr2++;
            }
            end--;
        }
        return arr;
    }

    /**
     * By keeping track of a iteration in which there is no swap in any two elements,
     * that means array is already sorted.
     * Thus, by breaking the loop when there was no swap, can improve
     * the complexity to O(n) in best case.
     * @param arr
     * @return
     */
    private static int[] optimizedBubble(int arr[]) {
        int end = arr.length;
        while (end > 1) {
            int ptr1 = 0;
            int ptr2 = 1;
            boolean isSorted = true;
            while (ptr2 < end) {
                if (arr[ptr1] > arr[ptr2]) {
                    swap(arr, ptr1, ptr2);
                    isSorted = false;
                }
                ptr1++;
                ptr2++;
            }
            if (isSorted) {
                break;
            }
            end--;
        }
        return arr;
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
