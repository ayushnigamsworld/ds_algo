package virtusa;

import java.util.function.Consumer;

public class Mcq2 {
    public static void main(String[] args) {
        int a = 5;
//        try {
//            throw a;
//        } catch (double b) {
//
//        }

        Consumer<String> print = x -> System.out.println(x);
        print.accept("ss");
    }
}
