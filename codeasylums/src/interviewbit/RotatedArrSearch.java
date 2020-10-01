package interviewbit;

public class RotatedArrSearch {

    public static void main(String[] args) {
        int arr[] = new int[] {5, 6, 0, 1, 2, 3, 4};
        search(arr, 4);
    }

    public static int search(final int[] A, int B) {
        int pivot = findPivot(A, B);
        if (A[pivot] == B) {
            return pivot;
        }
        int result = -1;
        if (B < A[pivot]) {
            result = simpleBinary(A, B, 0, pivot);
        } else {
            result = simpleBinary(A, B, pivot, A.length - 1);
        }
        return result;
    }

    private static int findPivot(int[] arr, int a) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == a) {
                return mid;
            }

            if (mid == 0 || arr[mid-1] > arr[mid]) {
                return mid;
            }
            else if(mid == arr.length - 1 || arr[mid] > arr[mid + 1]) {
                return mid;

            } else if (arr[mid] > arr[arr.length -1]) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    private static int simpleBinary(int[] arr, int a, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == a) {
                return mid;

            } else if (arr[mid] < a) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
