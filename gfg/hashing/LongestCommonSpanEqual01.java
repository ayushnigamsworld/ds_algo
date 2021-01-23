package hashing;

public class LongestCommonSpanEqual01 {

    public static void main(String[] args) {

        int ar1[] = {1, 1, 1, 0, 1, 1, 1};
        int ar2[] = {1, 1, 0, 1, 0, 1, 1, 0, 1};
        //           0  0  1 -1  1  0  0       After subtraction)
        //           0  0  1  0  1  1  1
        longestCommonSpan01(ar1, ar2);
    }

    static void longestCommonSpan01(int a1[], int a2[]) {
        int a[] = new int[a1.length + a2.length];
        for (int i=0; i< a1.length; i++) {

        }
    }
}
