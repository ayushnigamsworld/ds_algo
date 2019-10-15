package recursion;

public class RopeCuts {

    public static void main(String a[]) {
        RopeCuts ropeCuts = new RopeCuts();
        int res = ropeCuts.findMaxCuts(5, 2 ,1, 5);
        System.out.println(res);
    }
    private int findMaxCuts(int N, int a, int b, int c) {
        if (N == 0) return 0;
        if (N < 0) return -1;

        int cutA = findMaxCuts(N - a, a, b, c);
        int cutB = findMaxCuts(N - b, a, b, c);
        int cutC = findMaxCuts(N - c, a, b, c);
        int res = Math.max(cutA, Math.max(cutB, cutC));
        if (res >=0 ) return res + 1;
        else return -1;
    }
}
