package hackerrank.hcl.javaspringbootkafka;

public class DivisionChec {

    public static void main(String[] args) {
        double d = 10.0 / -0;
        if (d == Double.POSITIVE_INFINITY) {
            System.out.println("ss");
        } else {
            System.out.println("nn");
        }
    }
}
