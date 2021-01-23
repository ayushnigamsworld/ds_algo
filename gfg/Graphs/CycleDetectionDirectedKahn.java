package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Cycle detection in directed using Kahn i.e. indegree of nodes
 */
public class CycleDetectionDirectedKahn extends BaseGraph {

    private static boolean visited[];
    private static int indegree[];
    private static int V;
    /**
     *  1-->7-->3-->4
     *          /|  |
     *          |  \/
     *          2<--5-->6
     */
    public static void main(String[] args) {
        V = 8;
        visited = new boolean[V];
        indegree = new int[V];
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
        System.out.println(cycleDetectionKahn(mygraph));
    }

    private static boolean cycleDetectionKahn(List<List<Integer>> mygraph) {
        populateIndegree(mygraph);
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                count++;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            for (int a: mygraph.get(queue.poll())) {
                indegree[a]--;
                if (indegree[a] == 0) {
                    queue.add(a);
                    count++;
                }
            }
        }
        return count != V-1;
    }

    private static void populateIndegree(List<List<Integer>> mygraph) {
        for (List<Integer> ls: mygraph) {
            for (Integer a: ls) {
                indegree[a]++;
            }
        }
    }
}
