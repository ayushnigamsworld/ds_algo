package ikm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMap {

    public static void main(String[] args) {
        List<Map<List<Integer>, List<String>>> off = new ArrayList<>();
        Map<List<Integer>, List<String>> offMap = new HashMap<>();

        off.add(null);
        off.add(offMap);
        off.add(new HashMap<List<Integer>, List<String>>());
        off.forEach( e -> System.out.println(e + " "));
    }
}
