package hackerrank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Hackerrank {

    public static void main(String[] args) {

        Map<Integer, Integer> mp = new HashMap<>();
        mp.forEach( (k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
