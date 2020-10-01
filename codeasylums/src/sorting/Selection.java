package sorting;

public class Selection {

    public static void main(String[] args) {
        int res[] = selection(new int[] {3, 1, 1, 5, 6, 2, 4});
        for (int a: res) {
            System.out.println(a);
        }
    }

    private static int[] selection(int arr[]) {
        int start = 0;
        while (start < arr.length) {
            int minFinder = start;
            int tempMinIndex = start;
            int temp = Integer.MAX_VALUE;
            while (minFinder < arr.length) {
                if (temp > arr[minFinder]) {
                    tempMinIndex = minFinder;
                    temp = arr[minFinder];
                }
                minFinder++;
            }
            swap(arr, tempMinIndex, start);
            start++;
        }
        return arr;
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
