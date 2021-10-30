package hackerrank.apple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question1 {

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        Set<HashMap<Integer, String>> set = new HashSet<>();

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");
        set.add(map1);

        //Same as map1
        HashMap<Integer, String> map2 = new HashMap<>();

        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");
        System.out.println(set.contains(map2));

        //Different from map1
        HashMap<Integer, String> map3 = new HashMap<>();

        map3.put(1, "A");
        map3.put(2, "B");
        map3.put(3, "C");
        map3.put(3, "D");
        System.out.println(set.contains(map3));
    }
}
