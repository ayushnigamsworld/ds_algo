package mettle;

public class ModularExponentiation {

    public static void main(String[] args) {

    }

    static int power(int input1, int input2, int input3)
    {
        int output = 1;

        input1 = input1 % input3;

        if (input1 == 0)
            return 0;

        while (input2 > 0)
        {
            if ((input2 & 1) != 0) {
                output = (output * input1) % input3;
            }

            input2 = input2 >> 1;
            input1 = (input1 * input1) % input3;
        }
        return output;
    }
}
