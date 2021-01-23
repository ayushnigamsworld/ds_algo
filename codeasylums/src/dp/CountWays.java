package dp;

public class CountWays {

    public static void main(String[] args) {
        int total = 4; // expected ans: 7
        System.out.println(countWays(total));
    }

    private static int countWays(int remaining) {
        if (remaining == 0) {
            return 1;
        }
        if (remaining < 0) {
            return 0;
        }
        int ans = countWays(remaining - 1) + countWays(remaining - 2) + countWays(remaining - 3);
        return ans;
    }
}
