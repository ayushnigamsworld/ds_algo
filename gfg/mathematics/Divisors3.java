package mathematics;

public class Divisors3 {
    public static void main(String a[]) {
        int n = 122;
        int count = 0;
        Divisors3 divisors3 = new Divisors3();
        int N = (int)Math.sqrt(n);
        for (int i = 2; i<= N; i++){
            if (divisors3.checkIfPrime(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public boolean checkIfPrime(int n) {
        if (n<=1) return false;
        if (n<=3) return true;
        if (n%2 == 0 || n%3 == 0) return false;
        for (int i=5; i*i<=n; i+=6) {
            if (n%i == 0 || n%(i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}
