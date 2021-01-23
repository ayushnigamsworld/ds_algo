package Heap;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;
    MinHeap(int n) {
        arr = new int[n];
        size = 0;
        capacity = n;
    }

    int left(int i) {
        return (2*i + 1);
    }

    int right(int i) {
        return (2*i + 2);
    }

    int parent(int i) {
        return (i-1/2);
    }

    void insert(int data) {
        if (size == capacity) {
            throw new Error();
        }
        arr[size] = data;
        size++;
        for (int i = size; i!= 0 && arr[i] < arr[parent(i)];) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    void heapify(int i) {
        int left = left(i);
        int right = right(i);
        // find the smaller one.
        int smaller = i;
        // check for existence of left and right too.
        if (left < size && arr[i] > arr[left]) {
            smaller = left;
        }
        if (right < size && arr[i] > arr[right]) {
            smaller = right;
        }
        // swap and repeat for the smaller one.
        if (smaller != i) {
            swap(arr, smaller, i);
            heapify(smaller);
        }
    }

    int extractMin() {
        int min = arr[0];
        swap(arr, 0, size);
        heapify(0);
        return min;
    }

    void decreaseKey(int index, int x) {
        arr[index] = x;
        int i= index;
        while (i!=0 && arr[parent(i)] > arr[i]) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    // Start with bottommost rightmost
    // ie. parent( size -1 )
    void buildHeap(int arr[]) {
        for (int i= (size-2)/2; i>=0; i--) {
            heapify(i);
        }
    }

    private static void swap(int arr[], int i, int parent) {
        int temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;
    }
}

class UseMyHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(8);

    }
}
