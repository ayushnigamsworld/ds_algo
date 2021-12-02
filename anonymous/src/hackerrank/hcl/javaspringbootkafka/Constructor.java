package hackerrank.hcl.javaspringbootkafka;

import java.util.function.Consumer;

public class Constructor {

    static String str;
    public void Constructor() {
        System.out.println("in con");
        str = "Hello";
    }

    public static void main(String[] args) {
        Constructor c = new Constructor();
        System.out.println(str);
    }
}
