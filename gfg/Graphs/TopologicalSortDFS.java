package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * i.e. using stacks instead of queue by kahn that was in BFS.
 */
public class TopologicalSortDFS extends BaseGraph {

    private static boolean visited[];
    private static Stack<Integer> st;
    /**
     *       2   1
     *     /  \ / \
     *    5 -->3   4
     */
    public static void main(String[] args) {
        int V = 6;
        visited = new boolean[V];
        st = new Stack<>();
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
        addDirectedEdge(2, 5, mygraph);
        addDirectedEdge(2, 3, mygraph);
        addDirectedEdge(5, 3, mygraph);
        addDirectedEdge(1, 3, mygraph);
        addDirectedEdge(1, 4, mygraph);
        for (int i=1; i<V; i++) {
            if (!visited[i]) {
                topologicalSort(mygraph, i);
            }
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    private static void topologicalSort(List<List<Integer>> mygraph, int s) {
        visited[s] = true;
        List<Integer> list = mygraph.get(s);
        for (Integer a: list) {
            if (!visited[a]) {
                topologicalSort(mygraph, a);
            }
        }
        st.push(s);
    }
}
