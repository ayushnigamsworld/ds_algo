package fiftyfivetechnology;

import java.util.ArrayList;
import java.util.List;

/**
 * A1: [1,6], A2: [1, 2, 3, 4, 5, 9]
   Output: [1, 1, 2, 3, 4, 5, 6, 9]
 */

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(6);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(9);
        Test1 test1 = new Test1();
        System.out.println(test1.merge(list1, list2));
    }

    public List<Integer> merge(List<Integer> inp1, List<Integer> inp2) {
        int first = 0;
        int second = 0;
        List<Integer> result = new ArrayList<>();
        while (first < inp1.size() && second < inp2.size()) {
            if (inp1.get(first) <= inp2.get(second)) {
                result.add(inp1.get(first));
                first++;
            } else {
                result.add(inp2.get(second));
                second++;
            }
        }
        while (first < inp1.size()) {
            result.add(inp1.get(first));
            first++;
        }
        while (second < inp2.size()) {
            result.add(inp2.get(second));
            second++;
        }
        return result;
    }
}
