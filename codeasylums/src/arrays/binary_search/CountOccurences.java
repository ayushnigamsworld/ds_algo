package arrays.binary_search;

public class CountOccurences {
    public static void main(String[] args) {
        int inp[] = {1, 1, 2, 2, 2, 2, 2, 4, 4, 6, 6, 6, 7};
        int l = findLeftMost(inp, 0, inp.length -1, 6);
        int r = findRightMost(inp, 0, inp.length -1, 6);
        int count = r - l + 1;
        System.out.println(count);
    }

    private static int findLeftMost(int inp[], int l, int r, int x) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l)/2;
        if ((mid == 0 || inp[mid - 1] < inp[mid]) && inp[mid] == x ) {
            return mid;

        } else if (inp[mid] >= x) {
            return findLeftMost(inp, l, mid - 1, x);
        } else {
            return findLeftMost(inp, mid + 1, r, x);
        }
    }

    private static int findRightMost(int inp[], int l, int r, int x) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l)/2;
        if ((mid == inp.length-1 || inp[mid+1] > inp[mid] ) && inp[mid] == x) {
            return mid;

        } else if (inp[mid] <= x) {
            return findRightMost(inp, mid +1, r, x);

        } else {
            return findRightMost(inp, l, mid - 1, x);
        }
    }
}
