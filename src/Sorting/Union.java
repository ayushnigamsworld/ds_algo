package Sorting;

public class Union {
    public static void main(String arre[]) {
        int input1[] = {1, 2, 3, 4, 5};
        int input2[] = {1, 2, 3};
        findUnion(input1, input2, input1.length, input2.length);
    }
    static void findUnion(int arr1[], int arr2[], int n, int m)
    {
        int merged[] = new int[n+m];
        int i=0, j=0, k=0;
        while(i< n && j < m) {

            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i++;

            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        for (int p=0; p<(n+m); p++) {
            System.out.print(merged[p] + " ");
            while ((p+1)<(n+m) && merged[p+1] == merged[p]) {
                p++;
            }
        }
    }
}
