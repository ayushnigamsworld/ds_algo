package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String arr[]) {
        Combinations combinations = new Combinations();
        List<String> result = new ArrayList();
        combinations.powerSet("abc", "", 0, result);
        System.out.println(result);
    }
    private void powerSet(String str, String output, int index, List<String> result) {
        if (index == str.length()) {
            result.add(output);
            //System.out.println(output);
            return;
        }
        powerSet(str, output + str.charAt(index), index + 1, result);
        powerSet(str, output, index + 1, result);
    }
}
