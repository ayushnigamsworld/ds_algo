package glider.tasks10;

public class OutputDoubleInt {


    public static void main(String[] args) {
        Double o = new Double("2.4");
        int a = o.intValue();
        double b = o.doubleValue();
        float c = o.floatValue();
        System.out.println(a + b + c);
    }
}
