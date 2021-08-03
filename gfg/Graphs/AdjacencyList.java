package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * For undirected graph.
 *
 *    0 -- 1
 *    |  /
 *    2 -- 3
 *
 */
public class AdjacencyList {

    private static boolean[] visited;
    static int V = 4;
    public static void main(String[] args) {
        List<Set<Integer>> adjacencyList = new ArrayList<>(V);
        for (int i=0; i<V; i++) {
            adjacencyList.add(new HashSet<>());
        }
        visited = new boolean[V+1];
        addEdge(0, 2, adjacencyList);
        addEdge(1, 2, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(2, 3, adjacencyList);
        System.out.println(edgeExists(2, 3, adjacencyList));
    }

    private static void addEdge(int a, int b, List<Set<Integer>> adjacencyList) {
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
        visited[a] = true;
        visited[b] = true;
    }

    private static boolean edgeExists(int a, int b, List<Set<Integer>> adjacencyList) {
        if (!(a >= 1 && a<=V)) {
            return false;
        }
        if (!visited[a] || !visited[b]) {
            return false;
        }
        Set<Integer> set = adjacencyList.get(a);
        return set.contains(b);
    }
}
