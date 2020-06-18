package Sorting;

public class QuickSort {
    public static void main(String[] aa) {
        int[] arr = {5, 4, 7, 3, 8, 2, 6};
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int p = partition(arr, low, high);
        quickSort(arr, low, p-1);
        quickSort(arr, p+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotPtr = low;
        for (int i=low; i<=high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pivotPtr);
                pivotPtr++;
            }
        }
        swap(arr, pivotPtr, high);
        return pivotPtr;
    }

    private static void swap(int[] arr, int src, int dest) {
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
}
