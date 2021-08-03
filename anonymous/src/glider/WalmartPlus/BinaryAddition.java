package glider.WalmartPlus;

public class BinaryAddition {

    public static void main(String[] args) {
        System.out.println(addBinary("1101", "100"));
    }

    static String addBinary(String a, String b)
    {
        String sum = "";
        int s = 0;

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            sum = (char)(s % 2 + '0') + sum;

            s /= 2;
            i--; j--;
        }

        return sum;
    }
}
