package Stack;

public class NextGreater {

    public static void main(String[] args) {
        int inp[] = {5, 15, 10, 8, 6, 12, 9, 18};
        int res[] = nextGreater(inp);
        for (int r: res) {
            System.out.print(r + " ");
        }
    }

    private static int[] nextGreater(int arr[]) {
        int inp[] = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            inp[i] = arr[arr.length-i-1];
        }
        int res[] = PreviousGreater.previousGreater(inp);
        int resRev[] = new int[arr.length];
        for (int i=0; i<res.length; i++) {
            resRev[i] = res[res.length-i-1];
        }
        return resRev;
    }
}
