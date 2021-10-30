package hackerrank.visa;

public class Rec {

    public static void main(String[] args) {
        System.out.println(func(3, 5));
    }

    private static int func(int a, int b) {
        if (b== 0) {
            return 1;
        }

        int temp = func(a, b/2);
        if (b % 2 != 0) {
            return temp * temp * a;
        }
        else
        {
            return temp * temp;
        }
    }
}
