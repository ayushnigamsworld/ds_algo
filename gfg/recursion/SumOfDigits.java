package recursion;

public class SumOfDigits {
    public static void main(String ar[]) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int result = sumOfDigits.digitalRoot(191);
        System.out.println(result);
    }

    private int digitalRoot(int n) {
        int res = sumOfDigits(n);
        while((res / 10) >= 1) {
            res = sumOfDigits(res);
        }
        return res;
    }

    private int sumOfDigits(int n) {
        if (n < 10) return n;

        return (n % 10) + sumOfDigits(n/10);
    }
}
