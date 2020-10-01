package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int inp[] = {2, 8, 1, 5, 3, 9, 7};
        sort(inp, 0, inp.length-1);
        for (int a: inp) {
            System.out.println(a);
        }
    }

    private static void sort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low)/2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        for (int i= 0; i< n1; i++) {
            arr1[i] = arr[i + low];
        }
        for (int i= 0; i<n2; i++) {
            arr2[i] = arr[mid + 1 + i];
        }
        int cnt = low;
        int a1 = 0;
        int b1 = 0;
        while (a1 < n1 && b1 < n2) {
            if (arr1[a1] <= arr2[b1]) {
                arr[cnt] = arr1[a1++];
            } else {
                arr[cnt] = arr2[b1++];
            }
            cnt++;
        }
        while (a1 < n1) {
            arr[cnt++] = arr1[a1++];
        }
        while (b1 < n2) {
            arr[cnt++] = arr2[b1++];
        }
    }
}
