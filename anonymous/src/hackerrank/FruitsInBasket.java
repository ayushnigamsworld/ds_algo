package hackerrank;

import java.util.Collections;
import java.util.HashMap;

public class FruitsInBasket {

    public static void main(String[] args) {
        char fruits[] = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(char[] fruits) {
        int start = 0;
        int n = fruits.length;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(fruits[i], i);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(fruits[minIndex]);
                start = minIndex + 1;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
