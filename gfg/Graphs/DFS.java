package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS extends BaseGraph {

    private static boolean visited[];

    /**
     *    1---3---4
     *    |
     *    2---5
     */
    public static void main(String[] args) {
        int V = 6;
        visited = new boolean[V];
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
        addEdge(1, 3, mygraph);
        addEdge(1, 2, mygraph);
        addEdge(3, 4, mygraph);
        addEdge(2, 5, mygraph);
        dfs(mygraph, 1);
    }

    private static void dfs(List<List<Integer>> mygraph, int s) {
        if (visited[s]) {
            return;
        }
        List<Integer> neighbors = mygraph.get(s);
        System.out.println(s);
        visited[s] = true;
        for (int i: neighbors) {
            if (!visited[i]) {
                dfs(mygraph, i);
            }
        }
    }
}
