package hackerrank.amazon;

import java.util.ArrayList;
import java.util.List;

public class ReassignPriorities {

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(3);
        ls.add(7);
        ls.add(3);
        System.out.println(reassignedPriorities(ls));
    }

    public static List<Integer> reassignedPriorities (List<Integer> priorities) {
        int[] countArr = new int[100];

        for (int priority : priorities) {
            countArr[priority]++;
        }

        int reassignPriority = 1;

        for (int i = 1; i < countArr.length; i++) {
            if (countArr[i] > 0){
                countArr[i] = reassignPriority++;
            }
        }

        int size = priorities.size();

        for (int i = 0; i < size; i++) {
            int current = countArr[priorities.get(i)];
            priorities.set(i, current);
        }

        return priorities;
    }
}
