package stack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/
 */
public class StockSpan {

    private static Stack<Pair> stack = new Stack<>();
    private static List<Integer> resultList = new ArrayList<>();
    public static void main(String[] args) {
    }

    private static void stockSpan(int input) {
        if (stack.isEmpty()) {
            stack.push(new Pair(input, 1));
            resultList.add(1);
        }
        if (input < stack.peek().price) {
            stack.push(new Pair(input, 1));
            resultList.add(1);
        }
        int result = 1;
        while (!stack.isEmpty() && input >= stack.peek().price) {
            result += stack.pop().span;
        }
        stack.push(new Pair(input, result));
        resultList.add(result);
    }
}

class Pair {
    int price;
    int span;
    Pair(int price, int spanl) {
        this.price = price;
        this.span = spanl;
    }
}
