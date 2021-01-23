package Stack;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int res[] = stockSpan(new int[]{15, 13, 12, 14, 16, 8, 6, 4, 10, 30});
        for (int r: res) {
            System.out.print(r+ " ");
        }
    }

    private static int[] stockSpan(int stock[]) {
        int res[] = new int[stock.length];
        Stack<StockSpanRate> stockStack = new Stack<>();
        stockStack.push(new StockSpanRate(stock[0], 1));
        res[0] = 1;
        int i=1;
        while (i<stock.length) {
            int currentStock = stock[i];
            StockSpanRate topStockSpanRate = stockStack.peek();
            if (currentStock < topStockSpanRate.stock) {
                stockStack.push(new StockSpanRate(stock[i], 1));
                res[i] = 1;
            } else {
                int cnt = 0;
                while (!stockStack.isEmpty() && stockStack.peek().stock < currentStock) {
                    cnt += stockStack.pop().rate;
                }
                stockStack.push(new StockSpanRate(stock[i], cnt + 1));
                res[i] = cnt + 1;
            }
            i++;
        }
        return res;
    }
}

class StockSpanRate {
    int stock;
    int rate;
    public StockSpanRate(int stock, int rate) {
        this.stock = stock;
        this.rate = rate;
    }
}
