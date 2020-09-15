package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * For undirected graph.
 *
 *    0 -- 1
 *    |  /
 *    2 -- 3
 *
 */
public class AdjacencyList {

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adjacencyList = new ArrayList<>(V);
        for (int i=0; i<V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addEdge(0, 1, adjacencyList);
        addEdge(1, 2, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(2, 3, adjacencyList);
    }

    private static void addEdge(int a, int b, List<List<Integer>> adjacencyList) {
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
    }
}
