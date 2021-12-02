package general;

import java.util.ArrayList;
import java.util.List;

public class TypeChecking {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        list.add("hello");
        list.add(21);
        List<Integer> integerList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        for (Object o: list) {
            if (o instanceof String) {
                strList.add((String)o);
            }
            if (o instanceof Integer) {
                integerList.add((Integer)o);
            }
        }
        System.out.println(integerList);
    }
}
