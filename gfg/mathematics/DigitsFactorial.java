package mathematics;

import java.math.BigInteger;

public class DigitsFactorial {
    public static void main(String a[]) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.digitsInFactorial(8468));
    }
}

class Factorial
{

    public long digitsInFactorial(int N)
    {
        BigInteger fact = new BigInteger("1");
        //long fact = 1;
        for (int i = 2; i<= N; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        //System.out.println(fact.bitLength());
        System.out.println(fact.toString().length());
        //return fact.toString().length();
        return (long)Math.floor(Math.log10(fact.longValue()) + 1);
    }
}
