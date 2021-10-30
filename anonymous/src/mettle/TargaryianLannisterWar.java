package mettle;

import java.util.HashMap;
import java.util.Map;

public class TargaryianLannisterWar {

    public static void main(String[] args) {

        int[] input2 = new int[]{9, 22, 6, 5, 2, 3, 1, 2};
        int[] res = find(input2);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] find(int[] input2) {
        int[] result = new int[4];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<input2.length; i++) {
            map.put(input2[i], i);
        }
        for(int i=0; i<input2.length- 3; i++) {
            int first = input2[i];
            map.remove(first);
            for (int k=i+1; k<input2.length-2; k++) {
                int second = input2[k];
                int sum = first + second;
                map.remove(second);
                for (int j=0; j<input2.length; j++) {
                    if (j == i || j == k) continue;
                    int third = input2[j];
                    int fourth = sum - third;
                    if (map.containsKey(fourth)) {
                        result[0] = i;
                        result[1] = k;
                        result[2] = j;
                        result[3] = map.get(fourth);
                        return result;
                    }
                }
                map.put(second, k);
            }
            map.put(first, i);
        }
        return new int[]{-1};
    }
}
