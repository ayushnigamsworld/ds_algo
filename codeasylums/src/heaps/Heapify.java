package heaps;

public class Heapify {

    public static void main(String[] args) {

        String ten = "8000000";
        String three = "6000000";
        int tenI = Integer.parseInt(ten);
        int threeI = Integer.parseInt(three);
        System.out.println(tenI > threeI);
    }

    private static void heapify(int arr[], int root) {
        int largest = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left < arr.length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(arr, largest, root);
            heapify(arr, largest);
        }
    }

    private static void swap(int arr[], int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
