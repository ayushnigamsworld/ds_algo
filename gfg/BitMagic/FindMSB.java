package BitMagic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindMSB {
    public static void main(String aa[]) throws Exception {
        int result = findMSB(17); // 10001
        System.out.println(result); //  10000
    }
    private static int findMSB(int n) {
        int k = (int) (Math.log(n) / Math.log(2));
        return (int) Math.pow(2, k);
    }
}
