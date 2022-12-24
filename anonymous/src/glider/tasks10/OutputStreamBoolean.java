package glider.tasks10;

import java.util.stream.Stream;

public class OutputStreamBoolean {

    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("123", "234", "345");
        boolean match = s1.filter(a -> a.length() > 4).allMatch(s -> s.contains("0"));
        System.out.println(match);
    }
}
