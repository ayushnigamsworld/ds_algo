package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] inp= new int[]{9, 7, 1, 2, 6, 9, 5};
        int[] inp2= new int[]{7, 10, 1, 2, 6, 9, 8};
        int[] inp3= new int[]{1, 2, 3, 4, 5, 6, 8};
        quickSort(inp2, 0, inp2.length - 1);
        for (int a: inp2) {
            System.out.println(a);
        }
    }

    private static int placeNumberAtCorrectPositionDhruvs(int arr[], int low, int high, int x) {
        while (low <= high) {
            while (low < arr.length && arr[low] <= arr[x]) {
                low++;
            }
            while (high >= 0 && arr[high] >= arr[x]) {
                high--;
            }
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    /*private static int partition (int arr[], int low, int high, int x) {

    }*/

    private static int placeNumberAtCorrectPositionMine(int arr[], int low, int high, int x) {
        while (low <= high) {
            if (arr[low] > arr[x] && arr[high] < arr[x]) {
                swap(arr, low, high);
                low++;
                high--;
            }
            if (arr[low] <= arr[x]) {
                low++;
            }
            if (arr[high] >= arr[x]) {
                high--;
            }
        }
        swap(arr, low, x);
        return low;
    }

    private static int actualPartitioner(int arr[], int low, int high, int x) {
        int left = low - 1;
        for (int i=low; i<=high; i++) {
            int currentEle = arr[i];
            int pivot = arr[x];
            if ( currentEle < pivot ) {
                left++;
                swap(arr, left, i);
            }
        }
        swap(arr, left + 1, x);
        return left + 1;
    }

    private static void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int x = (low + high)/2;
        int pivot = actualPartitioner(arr, low, high, x);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] =  temp;
    }
}
