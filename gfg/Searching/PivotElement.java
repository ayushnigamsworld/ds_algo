package Searching;

/**'
 * In rotated array, minimum element is the pivot element around which it is rotated.
 */
public class PivotElement {

    public static void main(String aa[]) {
        int arr[] = {3, 4, 5, 1, 2};
        System.out.println(minNumber(arr, 0, arr.length - 1));
    }

    static long minNumber(int arr[], int low, int high)
    {
        // Using basic Binary Searching
        while(low <= high) {
            int mid = (int)(low + (high - low)/2);
            // Result is when mid element is smaller than one element before it
            if (mid < high && arr[ mid+ 1] < arr[mid]) {
                return arr[mid+1];
            }
            // Or When mid element is smaller than one element after it.
            if(mid > low && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            // Deciding to go left or right by comparing with corner element.
            // Anticlockwise, will have mid > last
            if(arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Clockwise will have mid < last
                high = mid - 1;
            }
        }
        return arr[0];
    }
}
