package Sorting;

public class InversionCount {
    static int result = 0;
    public static void main(String aaaa[]) {
        int input[] = {2, 3, 4, 5, 6};
        result = 0;
        breakMe(input, 0, input.length -1);
        for (int i=0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        System.out.println(result);
    }

    static void breakMe(int arr[], int low, int high) {
        if (low < high) {

            int m = low + (high - low)/2;
            breakMe(arr, low, m);
            breakMe(arr, m+1, high);
            result += countInversion(arr, low, m, high);
        }
    }

    static long countInversion(int arr[], int low, int m, int high) {
        long res = 0;
        int n1 = m - low + 1;
        int n2 = high - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i=0; i<n1; i++) {
            L[i] = arr[low + i];
        }
        for (int i=0; i<n2; i++) {
            R[i] = arr[m+1 + i];
        }
        int i=0, j=0, k=low;
        while (i < L.length && j < R.length) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;

            } else {
                arr[k] = R[j];
                j++;
                res += (L.length - i);
            }
            k++;
        }

        while(i < L.length) {
            arr[k] = L[i];
            k++;
            i++;
        }

        while(j < R.length) {
            arr[k] = R[j];
            k++;
            j++;
        }
        return res;
    }
}


