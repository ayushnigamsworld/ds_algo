package subsets;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.findPermutationsQueue(new int[] {1, 2, 3}));
    }

    private List<List<Integer>> findPermutationsQueue(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        int i = 0;
        while (!queue.isEmpty() && i < arr.length) {
            List<Integer> current = queue.poll();
            if (current.size() == arr.length) {
                result.add(current);
            }
            int num = arr[i];
            for (int j=0; j<=current.size(); j++) {
                List<Integer> temp = new ArrayList<>(current);
                temp.add(j, num);
                queue.add(temp);
            }
            i++;
        }
        return result;
    }
    private List<List<Integer>> findPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Collections.singletonList(arr[0])));
        for (int i=1; i<arr.length; i++) {
            int currentNum = arr[i];
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> existingList: result) {
                for (int j=0; j<=existingList.size(); j++) {
                    List<Integer> t = new ArrayList<>(existingList);
                    t.add(j, currentNum);
                    temp.add(t);
                }
            }
            result = temp;
        }
        return result;
    }
}
