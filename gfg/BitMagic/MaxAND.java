package BitMagic;

import java.util.ArrayList;
import java.util.List;

public class MaxAND {
    public static void main(String aa[]) {
        int res = maxAnd(new int[] {4, 8, 12, 16});
        System.out.println(res);
    }
    private static int maxAnd(int arr[]) {
        int maxMSB = 0;
        int finalResult = 0;
        for (int i=0;i< arr.length; i++) {
            int possibleMaxMsb = findMSB(arr[i]);
            if (maxMSB < possibleMaxMsb) {
                maxMSB = possibleMaxMsb;
            }
        }
        for (int i= maxMSB; i> 0; i = i>>1) {
            int count = 0;
            List<Integer> countList = new ArrayList<>();
            for (int j=0;j< arr.length; j++) {
                if ((arr[j] & i) >= i) {
                    count ++;
                    countList.add(arr[j]);
                }
            }
            if (count >=2 ) {
                for (int k =0; k<countList.size(); k++) {
                    for( int l = k + 1; l< countList.size(); l++) {
                        int localResult = countList.get(k) & countList.get(l);
                        if (finalResult < localResult) {
                            finalResult = localResult;
                        }
                    }
                }
                return finalResult;
            }
        }
        return finalResult;
    }
    private static int findMSB(int n) {
        int k = (int) (Math.log(n) / Math.log(2));
        return (int) Math.pow(2, k);
    }

}
