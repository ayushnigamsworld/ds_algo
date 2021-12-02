package easy;

public class BuySellStocks {

    int max = -1;
    public static void main(String[] args) {
        BuySellStocks buySellStocks = new BuySellStocks();
        int[] prices = {7,1,5,3,6,4};
//        buySellStocks.maxProfit(prices, 0, 0);
//        System.out.println(buySellStocks.max);
        int res = buySellStocks.maxProfit(prices);
        System.out.println(res);
    }

    public void maxProfit(int[] prices, int buyIndex, int sellIndex) {
        if (sellIndex == prices.length || buyIndex == prices.length) {
            return;
        }
        max = Math.max(prices[sellIndex] - prices[buyIndex], max);
        maxProfit(prices, buyIndex, sellIndex+1);
        maxProfit(prices, buyIndex+1, sellIndex+1);
    }

    public int maxProfit(int[] prices) {
        int minLocal = prices[0];
        int maxFinal = -1;
        for (int i=0; i<prices.length; i++)  {
            if (prices[i] < minLocal) {
                minLocal = prices[i];
            }
            maxFinal = Math.max(prices[i] - minLocal, maxFinal);
        }
        return maxFinal;
    }
}
