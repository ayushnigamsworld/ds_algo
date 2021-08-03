package glider.WalmartPlus;

public class CountPrime {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        boolean[] primeArr = new boolean[n +1];

        for(int i = 0 ; i <= n ; i++) {
            primeArr[i] = true;
        }

        primeArr[0] = false;
        primeArr[1] = false;

        for(int i = 2 ; i * i <= n ; i++) {
            if(primeArr[i]) {
                for(int j = i ; i * j <= n ; j++) {
                    primeArr[j * i ] = false;
                }
            }
        }

        int result = 0;
        for(int i = 2 ; i <= n ; i++) {
            if(primeArr[i]) {
                result++;
            }
        }

        return result;
    }
}
