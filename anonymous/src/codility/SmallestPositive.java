public class SmallestPositive {

    public static void main(String[] args) {
        solution(new int[] {1, 2, 3});
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = 1;
        for (int i=0; i<A.length; i++) {
            max = Math.max(max, A[i]);
        }
        if (max == 1) {
            return max;
        }
        boolean cache[] = new boolean[max+2];
        for (int i=0; i<A.length; i++) {
            if (A[i] > 0) {
                cache[A[i]] = true;
            }
        }

        for (int i=1; i<max; i++) {
            if (cache[i] == false) {
                return i;
            }
        }

        return 1;

    }
}
