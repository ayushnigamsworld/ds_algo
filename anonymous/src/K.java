import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class K {

    public static void main(String[] args) {
        /*StringBuilder res = new StringBuilder(inputStr);

        int i = 0;
        while (i + wrapLength < res.length() && (i = res.lastIndexOf(" ", i + wrapLength)) != -1) {
            res.replace(i, i + 1, "\n");
        }

        System.out.println(res.toString());*/

//        List<Number> ff = new ArrayList<Long>();
        /*ArrayList a = new ArrayList(2);
        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.size());*/
        /*int count = 0;
        for (long i=110; i<=130; i++) {
            if (isPerfectSquare(i)) {
                List<Integer> digits = findDigits(i);
                if (isZigZag(digits)) {
                    System.out.println(i);
                    count++;
                }
            }
        }
        System.out.println(count);*/
    }

    private static boolean isPerfectSquare(long n) {
        double a = Math.sqrt(n);
        return (a - Math.floor(a) == 0);
    }

    private static List<Integer> findDigits(long n) {
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            int digit = (int)n%10;
            result.add(digit);
            n = n/10;
        }
        return result;
    }

    private static boolean isZigZag(List<Integer> list) {
        for (int i=1; i<list.size(); i++) {
            if (i%2 == 0 && list.get(i) > list.get(i-1)) {
                return false;
            } else if (i%2 != 0 && list.get(i) < list.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}
