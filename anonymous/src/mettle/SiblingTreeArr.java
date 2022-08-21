package mettle;

import java.util.*;

public class SiblingTreeArr {

    public static void main(String[] args) {
        int input2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int input1 = input2.length;
        int input3 = 9;

        Set<Integer> result = findSiblings(input1, input2, input3);
        result.remove(input3);
        Integer[] inp = new Integer[result.size()-1];
        inp = result.toArray(inp);
        System.out.println(" -> "+ result);

        /*int parent = -1;
        for (int i=0; i<input2.length; i++) {
            int leftChild = 2*i + 1;
            int rightChild = 2*i + 2;
            if (leftChild< input1 && input2[leftChild] == input3) {
                parent = i;
                break;
            }
            if (rightChild < input1 && input2[rightChild] == input3) {
                parent = i;
                break;
            }
        }
        if (parent == -1) {
            System.out.println(-1);
            return;
        }

        List<Integer> result = new ArrayList<>();
        int lowerBound = input1;
        int upperBound = input1;
        for (int level=0; level<input1; level++) {
            lowerBound = (int)Math.pow(2, level) - 1;
            upperBound = lowerBound;
            if (level >= 1) {
                upperBound = (int)Math.pow(2, level) + (int)Math.pow(2, level-1) - 1;
            }
            if (parent >= lowerBound && parent <= upperBound) {
                break;
            }
        }
        for (int i=lowerBound; i<= upperBound; i++) {
            int leftChild = 2*i + 1;
            int rightChild = 2*i + 2;
            if (leftChild < input1 && input2[leftChild] != input3) {
                result.add(input2[leftChild]);
            }
            if (rightChild < input1 && input2[rightChild] != input3) {
                result.add(input2[rightChild]);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
            return;
        }
        Collections.sort(result);
        int output[] = new int[result.size()];
        for (int i=0; i<output.length; i++) {
            output[i] = result.get(i);
        }
        for (int i=0; i<output.length; i++) {
            System.out.println(output[i]);
        }*/
    }

    public static Set<Integer> findSiblings(int input1, int[] input2, int input3) {
        int[] result = new int[] {-1};
        int cnt = 0;
        for (int i=0; i<input1; i++) {
            int count = (int)Math.pow(2, cnt);
            Set<Integer> list = new HashSet<>();
            int end = i + count;
            for (int j=i; j<end && j<input1; j++) {
                list.add(input2[j]);
            }
            if (list.contains(input3)) {
                return list;
            }
            i = end-1;
            cnt++;
        }
        return null;

    }
}
