package hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MinimumSwapsToSort {

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{3, 1, 2}));
    }

    public static int minSwaps(int[] popularity)
    {
        int length = popularity.length;
        HashMap<Integer, Integer> pair = new HashMap<>();
        for(int i=0;i<length;i++)
            pair.put(popularity[i], i);

        Arrays.sort(popularity);

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[length];
        Arrays.fill(visited, false);

        // Initialize result
        int ans = 0;
        for(int i=0;i<length;i++) {

                // already swapped and corrected or
                // already present at correct pos
                if(visited[i] || pair.get(popularity[i]) == i)
                    continue;

                int j = i, cycleSize = 0;
                while(!visited[j]) {
                    visited[j] = true;

                    // move to next node
                    j = pair.get(popularity[j]);
                    cycleSize++;
                }

                // Update answer by adding current cycle.
                if(cycleSize > 0) {
                    ans += (cycleSize - 1);
                }
        }
        return ans;
    }
}
