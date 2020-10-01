package arrays.binary_search;

public class SimpleBinarySearch {

    public static void main(String[] args) {
        int inp[] = {1, 2, 3, 4, 5, 6, 7};
        int res = simpleBinarySearch(inp, 0, inp.length - 1, 7);
        System.out.println(res);
    }

    private static int simpleBinarySearch(int arr[], int start, int end, int x) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if (arr[mid] == x) {
            return mid;

        } else if (arr[mid] < x) {
            return simpleBinarySearch(arr, mid + 1, end, x);

        } else {
            return simpleBinarySearch(arr, start, mid - 1, x);
        }
    }
}
