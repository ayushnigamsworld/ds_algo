package mathematics;

import java.math.BigInteger;
import java.util.Arrays;

public class MeanMedian {
    public static void main(String a[]) {
        MeanMedian meanMedian = new MeanMedian();
        System.out.println(meanMedian.median(new int[]{1,4,5,9, 8, 9, 55, 7 ,1, 684,7}));
        System.out.println(meanMedian.mean(new int[]{1,4,5,9, 8, 9, 55, 7 ,1, 684,7}));
    }
    int median(int arr[]) {
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[(arr.length+1)/2] + arr[(arr.length-1)/2])/2;
        } else {
            return arr[arr.length/2];
        }
    }
    int mean(int arr[]) {
        BigInteger bigInteger = new BigInteger("0");
        for (int i=0; i< arr.length; i++) {
            bigInteger = bigInteger.add(BigInteger.valueOf(arr[i]));
        }
        return bigInteger.divide(BigInteger.valueOf(arr.length)).intValue();
    }
}
