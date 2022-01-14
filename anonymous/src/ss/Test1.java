package ss;

import java.util.HashSet;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.func("abcdabcde"));
    }

    private boolean func(String str) {
        // if str 0 return true
        boolean allEqual = true;
        int n = 1;
        int size = str.length();
        int current = 1;
        int previous = 0;
        while (current < size) {
            if (str.charAt(previous) != str.charAt(current)) {
                n = current + 1;
                previous = 0;
                allEqual = false;
            }
            else {
                int k = n;
                while (k > 0) {
                    if (current < size && str.charAt(previous) == str.charAt(current)) {
                        current++;
                        previous++;
                        k--;
                    }
                    else {
                        n = current + 1;
                        break;
                    }
                }

            }
            current++;
        }
         System.out.println(n);
        if (allEqual) {
            return n == size;
        } else {
            return n <= size/2;
        }
        // return str.substring(previous, current);
    }
}
