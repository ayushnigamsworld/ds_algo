package Array;

/**
 * O(n) time complexity
 * O(1) space complexity
 */
public class Rotation {
    public static void main(String aa[]) {
        int input[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int ninput[] = {1,2,3,4,5};
        rotate(ninput, 5, 2);
        for (int inp: ninput) {
            System.out.print(inp + " ");
        }
    }

    private static void rotate(int arr[], int n, int d) {
        int sets = gcd(n, d) <= 1 ? 2 : gcd(n, d);
        int start = 0;
        while(sets > 0) {
            shifting(arr, d, start);
            start ++;
            sets --;
        }
    }

    private static void shifting(int arr[], int d, int start) {
        int counter = start + d;
        int temp = arr[start];
        while(counter < arr.length) {
            arr[counter - d] = arr[counter];
            counter+= d;
        }
        arr[arr.length - d + start] = temp;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
