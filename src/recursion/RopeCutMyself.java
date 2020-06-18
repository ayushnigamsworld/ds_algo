package recursion;

public class RopeCutMyself {

    public static void main(String[] args) {
        System.out.println(ropeCut(5, 2, 5, 1));
    }
    private static int ropeCut(int n, int a, int b, int c) {

        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }

        int res1 = ropeCut(n-a, a, b, c);
        int res2 = ropeCut(n-b, a, b, c);
        int res3 = ropeCut(n-c, a, b, c);
        int res = Math.max(Math.max(res1, res2), res3);
        if (res >=0)
            return res + 1;
        else
            return -1;
    }
}
