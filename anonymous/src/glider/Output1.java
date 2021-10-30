package glider;

import java.util.Arrays;
import java.util.List;

public class Output1 {

    public static void main(String[] args) {
        List<String> j = Arrays.asList("Java6", "Java7", "Java8");
        boolean flag = j.stream().allMatch(str -> {
            System.out.println("Testing: " + str);
            return str.contains("8");
        });
        System.out.println(flag);
    }
}
