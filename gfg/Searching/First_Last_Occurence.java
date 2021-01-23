package Searching;
import java.util.*;

public class First_Last_Occurence {

    public static void main(String aeeee[]) {
        int arr[] = {3, 1 ,3, 3, 2};
        System.out.println(majority(arr, arr.length));
    }

    public static int majority(int arr[], int n) {
        Arrays.sort(arr);
        int mid = n/2;
        int element = arr[mid];
        int first = firstBinary(arr, element, mid);
        int last = lastBinary(arr, element, mid);
        int result = last - first + 1;
        if (result > (mid)) {
            return element;
        } else {
            return -1;
        }
    }

    public static int firstBinary(int arr[], int x, int high) {
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == x && ((mid - 1) < 0 || arr[mid - 1] != x)) {
                return mid;
            } else if (arr[mid] >= x) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int lastBinary(int arr[], int x, int low) {
        int n = arr.length;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == x && (mid + 1 >= n || arr[mid + 1] != x )) {
                return mid;
            } else if (arr[mid] <=x ) {
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
