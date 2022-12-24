package imocha.medium;

import java.util.*;

public class MinToReplaceDuplicate {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(2);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(3);
        System.out.println(minToReplace(input));
    }

    private static int minToReplace(List<Integer> input) {
        int result = 0;
        TreeMap<Integer, Integer> cache = new TreeMap<>((a,b) -> b - a);
        for (Integer a: input) {
            cache.put(a, cache.getOrDefault(a, 0) + 1);
        }

        int min = 1;
        for (int current: cache.keySet()) {
            while (cache.get(current) > 1) {
                while (cache.containsKey(min)) {
                    min += 1;
                }
                result += Math.abs(min - current);
                cache.put(current, cache.get(current) - 1);
                min += 1;
            }
        }
        return result;
    }

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return  a +
                    " -> " + b;
        }
    }
}
