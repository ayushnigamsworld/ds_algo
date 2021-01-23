package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectDirected extends BaseGraph {

    private static boolean visited[];
    private static boolean ancestor[];
    /**
     *  1-->7-->3-->4
     *          /|  |
     *          |  \/
     *          2<--5-->6
     */
    public static void main(String[] args) {
        int V = 8;
        visited = new boolean[V];
        ancestor = new boolean[V];
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
        addDirectedEdge(1, 7, mygraph);
        addDirectedEdge(7, 3, mygraph);
        addDirectedEdge(2, 3, mygraph);
        addDirectedEdge(3, 4, mygraph);
        addDirectedEdge(4, 5, mygraph);
        addDirectedEdge(5, 2, mygraph);
        addDirectedEdge(5, 6, mygraph);
        for (int i=1; i<V; i++) {
            if (cycleDetect(mygraph, 1)) System.out.println(true);
        }
    }

    private static boolean cycleDetect(List<List<Integer>> mygraph, int s) {
        visited[s] = true;
        ancestor[s] = true;
        for (Integer a: mygraph.get(s)) {
            if (!visited[a]) {
                if (cycleDetect(mygraph, a)) return true;
            } else if (ancestor[a]) {
                return true;
            }
        }
        ancestor[s] = false;
        return false;
    }
}
