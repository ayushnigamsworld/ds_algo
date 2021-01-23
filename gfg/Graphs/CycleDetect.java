package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetect extends BaseGraph {

    private static boolean visited[];
    /**
     *    1---3---4
     *        |   |
     *        2---5---6
     */
    public static void main(String[] args) {
        int V = 7;
        visited = new boolean[V];
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
        addEdge(1, 3, mygraph);
        addEdge(3, 2, mygraph);
        addEdge(3, 4, mygraph);
        addEdge(2, 5, mygraph);
        addEdge(4, 5, mygraph);
        addEdge(5, 6, mygraph);
        /*for (int i=1; i<V; i++) {
            if (detectCycle(mygraph, i, -1)) {
                System.out.println(true);
            }
        }*/
        System.out.println(detectCycle(mygraph, 1, -1));
    }

    private static boolean detectCycle(List<List<Integer>> mygraph, int s, int prev) {
        visited[s] = true;
        for (Integer a: mygraph.get(s)) {
            if (!visited[a]) {
                if (detectCycle(mygraph, a, s)) return true;
                visited[a] = true;
            } else if ( a != prev) {
                return true;
            }
        }
        return false;
    }
}
