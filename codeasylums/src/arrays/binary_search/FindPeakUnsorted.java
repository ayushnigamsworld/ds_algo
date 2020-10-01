package arrays.binary_search;

/**
 * Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours. For corner elements, we need to consider only one neighbour.
 Example:
 Input: array[]= {5, 10, 20, 15}
 Output: 20
 The element 20 has neighbours 10 and 15,
 both of them are less than 20.
 Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 Output: 20 or 90
 The element 20 has neighbours 10 and 15,
 both of them are less than 20, similarly 90 has neighbous 23 and 67.
 */
public class FindPeakUnsorted {
    public static void main(String[] args) {
        int inp[] = {11, 5, 10, 20, 15};
        if (inp.length < 1) {
            System.out.println(inp[0]);
        }
        int res = findPeak(inp, 0, inp.length - 1);
        System.out.println(res);
    }

    private static int findPeak(int arr[], int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if ((mid == 0 && arr [mid] > arr[mid + 1] ) || (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) ||
                (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) {
            return arr[mid];

        } else if (arr[mid - 1] > arr[mid + 1]) {
           return findPeak(arr, start, end - 1);

        } else {
           return findPeak(arr, mid + 1, end);
        }
    }
}
