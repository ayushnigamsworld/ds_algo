package recursion;

public class ReversePower {

    public static void main(String a[]) {
        ReversePower reversePower = new ReversePower();
        int nDigit = reversePower.noOfDigit(1234);
        int res = reversePower.reverseNumber(1234, nDigit-1);
        System.out.println(res);
        long finalOutput = reversePower.pow(71535, 53517);
        System.out.println(finalOutput);
    }
    private int reverseNumber(int n, int nDigit) {
        if (n < 10) return n;
        return (int)((n%10) * Math.pow(10, nDigit)) + reverseNumber(n/10, nDigit - 1);
    }
    private int noOfDigit(int n) {
        return (int)Math.floor(Math.log10(n) + 1);
    }
    private int simpleReverse(int n) {
        int rev =0;
        while (n>0) {
            rev = rev*10 + n%10;
            n = n/10;
        }
        return rev;
    }
    private long pow(int N, int R) {
        if (R == 1) return N;
        //long x = (long)(R * Math.log(N));
        //return (long)(Math.pow(Math.E, x) % 1000000007);
        //return (long)(Math.pow(N, R)% (1000000007));
        return ((pow(N,R-1)%(1000000007))*N%(1000000007))%(1000000007);
    }
}
