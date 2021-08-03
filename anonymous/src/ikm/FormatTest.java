package ikm;

import java.util.Formatter;

public class FormatTest {

    public static void main(String[] args) {
        String stringA = "A";
        String stringB = "B";
        String stringnull = null;
        StringBuilder bufferc = new StringBuilder("C");
        Formatter fmt = new Formatter(bufferc);

        fmt.format("%s%s", stringA, stringB);
        System.out.println("Line 1: " + fmt);

        fmt.format("%-2s", stringB);
        System.out.println("Line 2: " + fmt);

        fmt.format("%b", stringnull);
        System.out.println("Line 3: " + fmt);
    }
}
