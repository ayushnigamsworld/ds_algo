package Arrays;

public class CheckSortedRotated {
    public static void main(String aa[]) {
        int input1[] = {30, 20, 10, 50, 35};
        System.out.println(checkRotatedAndSorted(input1, input1.length));
    }

    public static boolean checkRotatedAndSorted(int arr[], int n){

        // Your code here
        int result = isAsc(arr, n);
        if (result == 0) {
            return false;
        }
        boolean isAsc = result == 1;
        int p = findPartition(arr, n, isAsc);
        if (p == -1) {
            return false;
        }
        rotation(arr, n, p);
        for (int i=0; i<n-1; i++) {
            if (!isAsc && arr[i] > arr[i+1]) {
                return false;
            } else if (isAsc && arr[i] < arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    private static int isAsc(int arr[], int n) {
        int minIndex = -1;
        int maxIndex = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex - minIndex == 1) {
            return 2;
        } else if (minIndex - maxIndex == 1){
            return 1;
        }
        return 0;
    }

    private static int findPartition(int arr[], int n, boolean isAsc) {
        if (isAsc) {
            for (int i=0; i< n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    return i;
                }
            }
        } else {
            for (int i=0; i< n-1; i++) {
                if (arr[i] < arr[i+1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static void rotation(int arr[], int n, int d) {
        reverse(arr, 0, d);
        reverse(arr, d+1, n-1);
    }

    private static void reverse(int arr[], int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
