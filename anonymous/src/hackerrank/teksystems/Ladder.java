package hackerrank.teksystems;

public class Ladder {

    public static void main(String[] args) {
        try {
            System.out.println(doStuff(args));
        } catch (Exception e) {
            System.out.println("exec");
        }
        doStuff(args);
    }

    static int doStuff(String[] args) {
        return Integer.parseInt("x");
    }
}
