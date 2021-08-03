package virtusa;

import org.omg.CORBA.INTERNAL;

public class Mcq1 {
    static boolean output(Integer a) {
        return Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }
    public static void main(String[] args) {
        System.out.println(output(2));
    }
}
