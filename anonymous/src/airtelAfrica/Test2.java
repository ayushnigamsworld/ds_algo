package airtelAfrica;

/**
 * [3, 2, 0, 1, -9, 0, 0, 8, 7]
 * Push zeroes to end
 * Time O(n) Space O(1)
 *
 * Output:
 * [3, 2, 1, -9, 8, 7, 0, 0, 0]
 *
 * 2 conditions
 * 2 pointers to keep track
 *
 */
public class Test2 {

    public static void main(String[] args) {
        int[] inp = {3, 0, 2, 0 ,0 ,0, 0, 1, 0, 0, 9, 8, 0};
        pushZeroesToEnd(inp);
        for (int i: inp)
        System.out.print(i + " ");
    }

    private static void pushZeroesToEnd(int[] inp) {
        int zeroPtr = -1;
        int current = 0;
        while (current < inp.length) {
            int currentElement = inp[current];
            if (currentElement == 0) {
                if (zeroPtr == -1) {
                    zeroPtr = current;
                }
            } else if (zeroPtr != -1) {
                inp[zeroPtr] = currentElement;
                inp[current] = 0;
                zeroPtr++;
            }
            current++;
        }
    }
}











