package athena;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * [2, 3, 6, 7]
 *
 * 7
 *
 * [[2, 2, 3], [7]]
 *
 */
public class Testss {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Testss testss = new Testss();
        int[] inp = {2, 3, 6, 7};
        int target = 7;
        testss.recurse(inp, target, inp.length-1, 0, new ArrayList<>());
        System.out.println(testss.result);
    }

    public void recurse(int[] inp, int target, int index, int sum, List<Integer> localResult) {

        if (index < 0) {
            return;
        }

        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(localResult);
            return;
        }

       List<Integer> modified = new ArrayList<>();
        modified.addAll(localResult);
       modified.add(inp[index]);
       recurse(inp, target, index, sum + inp[index], modified);
       recurse(inp, target, index - 1, sum, localResult);
    }
}
