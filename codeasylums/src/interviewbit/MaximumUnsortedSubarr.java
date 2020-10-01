package interviewbit;

public class MaximumUnsortedSubarr {

    public static void main(String[] args) {
//         int inp[] = {1, 2, 6, 3, 7, 5, 8};
//        int inp[] = {1, 3, 2, 2, 4, 5 };
        int inp[] = {4, 15, 4, 4, 15, 18, 20};
//        int inp[] = {1, 3, 4, 7, 6, 2, 12, 10, 9, 11};
//        int inp[] = {1, 2};
        int[] res= findUnsorted(inp);
        System.out.println(res[0] + " " + res[1]);
    }

    private static int[] findUnsorted(int arr[]) {
        int l = 0;
        int r = arr.length-1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                l = i-1;
                break;
            }
        }
        for (int i= arr.length-1; i>=1; i--) {
            if (arr[i-1] > arr[i]) {
                r = i-1;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=l; i<=r; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        for (int i=0; i<l; i++) {
            if (arr[i] > min) {
                l =i;
                break;
            }
        }

        for (int i=arr.length-1; i>r; i--) {
            if (arr[i] < max) {
                r = i;
                break;
            }
        }
        if (l==0 && r== arr.length-1) {
            return new int[]{-1};
        }
        return new int[]{l, r};
    }
}
