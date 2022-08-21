package airtelAfrica;

/**
 * [3, 2, 1, -9, 8, 7]
 * Second highest number
 * Time: O(n) Space: O(1)
 *
 */
public class Test1 {

    public static void main(String[] args) {
        int[] inp = {10, 3, 20, -1, 9, -8, -7};
        // int res = findSecondHighest(inp);
        //System.out.println(res);
        while (true) {
            Test1 test1 = new Test1();
        }
    }

    private static int findSecondHighest(int[] inp) {
        int second = Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;

        for (int current: inp) {
            if (current > first) {
                if (first > second) {
                    second = first;
                }
                first = current;
            } else if (current > second) {
                    second = current;
            }
        }

        return second;
    }

}
