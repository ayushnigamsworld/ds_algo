package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateSubsets {

    public static void main(String[] args) {
        DuplicateSubsets duplicateSubsets = new DuplicateSubsets();
        System.out.println(duplicateSubsets.findAllNonDuplicateSubsets(new int[] {1, 3, 3}));
    }

    private List<List<Integer>> findAllNonDuplicateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        result.add(new ArrayList<>());
        int endIndex = 0;
        for (int i=0; i<arr.length; i++) {
            int currentNum = arr[i];
            List<List<Integer>> newResult = new ArrayList<>();
            int startIndex = 0;
            if (i > 0 && currentNum == arr[i-1]) {
                startIndex = endIndex;
            }
            endIndex = result.size();
            newResult.addAll(result);
            for (int j=startIndex; j<endIndex; j++) {
                List<Integer> newCurrent = new ArrayList<>(result.get(j));
                newCurrent.add(currentNum);
                newResult.add(newCurrent);
            }
            result = newResult;
        }
        return result;
    }
}
