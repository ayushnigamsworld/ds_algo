package glider;

import java.util.ArrayList;
import java.util.List;

public class ListIntegerString {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        appendList(a);
        System.out.println(a.get(0));
    }

    public static void appendList(List a) {
        a.add("0042");
    }
}
