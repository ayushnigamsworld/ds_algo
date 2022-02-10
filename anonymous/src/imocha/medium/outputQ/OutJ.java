package imocha.medium.outputQ;

import java.util.HashSet;
import java.util.Set;

public class OutJ {

    public static void main(String[] args) {
        Set a = new HashSet();
        a.add(5);
        a.add("6");
        a.add(7);
        for (Object aa: a) {
            System.out.println(aa);
        }

        String s1 = "James";
        String s2 = new String("James");
        s2.intern();
        System.out.println(s1 == s2);
    }
}
