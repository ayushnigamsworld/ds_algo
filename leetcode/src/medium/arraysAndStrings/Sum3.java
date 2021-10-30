package medium.arraysAndStrings;

import java.util.*;

// 3Sum
public class Sum3 {

    public static void main(String[] args) {
         int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] arr = new int[]{1, 2, -2, -1};
       // int[] arr = new int[]{3, 0, -2, -1, 1, 2};
        System.out.println(find3Sum(arr));
    }

    public static List<List<Integer>> find3Sum(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Set<Integer>> bigCache = new HashSet<>();
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            cache.put(nums[i], i);
        }
        for (int i=0; i<nums.length-2; i++) {
            int target = -nums[i];
            for (int j=i+1; j<nums.length-1; j++) {
                int first = nums[j];
                int toFind = target - first;
                if (cache.containsKey(toFind)) {
                    int foundIndex = cache.get(toFind);
                    if (foundIndex > j && foundIndex < nums.length) {
                        List<Integer> localRes = new ArrayList<>();
                        localRes.add(-target);
                        localRes.add(first);
                        localRes.add(toFind);
                        Set<Integer> cc = new HashSet<>(localRes);
                        if (!bigCache.contains(cc)) {
                            result.add(localRes);
                        }
                        bigCache.add(cc);
                    }
                }
            }
        }
        return result;
    }

    static class Triplet {
        int first;
        int second;
        int third;
        public Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return first == triplet.first || first == triplet.second || first == triplet.third &&
                    second == triplet.first || second == triplet.second || second == triplet.third &&
                    third == triplet.first || third == triplet.second || third == triplet.third;
        }

        @Override
        public int hashCode() {
            int h = Objects.hash(first, second, third);
            return h;
        }
    }
}
