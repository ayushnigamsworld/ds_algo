package aa;

public class Powerpwe {


    /**
     *
     * Power of n without using Math.pow();
     *
     * 1. Repeated multiplication..
     *    n = 2, p = 8  2 ^ 8
     *    2 * 2 = 4 * 4 = 16 * 16
     *
     *    2 * 2 = 2 ^ 2
     *    4 * 4 =  2 ^ 8
      *   16 * 16 = 2 ^ 8
     *    3 steps rather than 8 steps..
     *
     *    2^ 5
     *    2 * 2 = 4
     *    4 * 4 = 2 ^ 4
     *    16 * 2
     *    O(log2 p)
     *
     *    O (p)
     *
     *    Multiplication: O(1)
     *      Repeated Addition. -- Bit Manipulation
     *      2 * 5 = 10, 2 + 2+ 2 + 2+ 2
     *      010 101  = 1010
     *
     * 2. Bit manipulation
     *    5^ 3 =  125
     *    101  011 = 1111101
     *    5  5
     *
     *    1111101
     *    5 ^ 4 = 625
     *    101 100  = 1001110001
     *
     *    < >
     *
     *
     */
    public static void main(String[] args) {
        String a = Integer.toBinaryString(10);
        System.out.println(a);
        int n = 5; int p = 3;


    }
}
