package medium.treeGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = coinChange.coinChange(coins, amount);
          System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        int result = 0;
        visited.add(amount);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int currentAmt = queue.poll();
                if (currentAmt < 0) {
                    continue;
                }
                if (currentAmt == 0) {
                    return result;
                }
                for (int coin: coins) {
                    int newAmount = currentAmt - coin;
                    if (newAmount >= 0 && !visited.contains(newAmount)) {
                        queue.offer(newAmount);
                        visited.add(newAmount);
                    }
                }
                size--;
            }
            result ++;
        }
        return -1;
    }
}
