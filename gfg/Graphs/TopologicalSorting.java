package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting extends BaseGraph {

    private static boolean visited[];
    private static int indegree[];

    /**
     *       2   1
     *     /  \ / \
     *    5 -->3   4
     */
    public static void main(String[] args) {
        int V = 6;
        visited = new boolean[V];
        indegree = new int[V];
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
//        addDirectedEdge(2, 5, mygraph);
//        addDirectedEdge(2, 3, mygraph);
//        addDirectedEdge(5, 3, mygraph);
//        addDirectedEdge(1, 3, mygraph);
//        addDirectedEdge(1, 4, mygraph);

        addDirectedEdge(2, 5, mygraph);
        addDirectedEdge(0, 5, mygraph);
        addDirectedEdge(0, 4, mygraph);
        addDirectedEdge(1, 4, mygraph);
        addDirectedEdge(3, 2, mygraph);
        addDirectedEdge(1, 3, mygraph);


        topologicalSort(mygraph);
    }

    private static void topologicalSort(List<List<Integer>> mygraph) {
        for (List<Integer> ls: mygraph) {
            for (int a: ls) {
                indegree[a]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            System.out.println(polled);
            for (Integer a: mygraph.get(polled)) {
                indegree[a]--;
                if (indegree[a] == 0) {
                    queue.add(a);
                }
            }
        }
    }
}
