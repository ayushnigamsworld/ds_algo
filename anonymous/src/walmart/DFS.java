package walmart;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 *
 *   1 --> 2 ---> 3
 *   |
 *   |
 *   4
 *
 *
 *   stack  |  Current element
 *
 *
 */
public class DFS {

    private boolean visited[];
    public static void main(String[] args) {

    }

    private void dfs(Map<Integer, List<Integer>> adjList,  int source) {

        System.out.println(source);
        if (!adjList.containsKey(source)) {
            return;
        }
        List<Integer> neighbourList = adjList.get(source);
        for (Integer neighbours : neighbourList) {
            dfs(adjList, neighbours);
        }
    }
}
