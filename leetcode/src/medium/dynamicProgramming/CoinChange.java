package medium.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        CoinChange coinChange = new CoinChange();
        int total = 11;
        int res = coinChange.coinChange(coins, total, 0);
//        int res = coinChange.coinChange(0, coins, total);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int total, int i) {
        if (total == 0) {
            return 0;
        }

        if (total < 0 || i == coins.length) {
            return -1;
        }

        int minCost = Integer.MAX_VALUE;
        int maxCoins = total / coins[i];
        for (int m=0; m<=maxCoins; m++) {
            if (total >= m * coins[i]) {
                int res = coinChange(coins, total - m * coins[i], i+1);
                if (res != -1) {
                    minCost = Math.min(res + m, minCost);
                }
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
