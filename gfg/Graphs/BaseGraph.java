package Graphs;

import java.util.List;
import java.util.Map;

public class BaseGraph extends Pair {

    public static void addEdge(int a, int b, List<List<Integer>> adjacencyList) {
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
    }

    public static void addDirectedEdge(int a, int b, List<List<Integer>> adjacencyList) {
        adjacencyList.get(a).add(b);
    }

    public static List<List<Pair>> weightedAdjList;
    public static boolean[] visited;
    public static int V;

    public static void addWeightedDirectedEdge(int a, int b, int weight) {
        weightedAdjList.get(a).add(new Pair(b, weight));
    }
}
