package subsets;

import java.util.*;

public class BalancedParanthesis {

    public static void main(String[] args) {
        System.out.println(generateBalancedParethesis(3));
    }

    public static List<String> generateBalancedParethesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis("", 0, 0));
        while (!queue.isEmpty()) {
            Parenthesis current = queue.poll();
            if (current.open == n && current.closed == n) {
                result.add(current.value);
            }
            String value = current.value;
            if (current.open < n) {
                queue.add(new Parenthesis(value + "(", current.open + 1, current.closed));
            }
            if (current.closed < current.open) {
                queue.add(new Parenthesis(value + ")", current.open, current.closed + 1));
            }
        }
        return result;
    }
}

class Parenthesis {
    String value;
    int open;
    int closed;

    public Parenthesis(String value, int open, int closed) {
        this.value = value;
        this.open = open;
        this.closed = closed;
    }
}
