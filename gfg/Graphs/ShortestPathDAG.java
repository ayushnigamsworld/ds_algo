package Graphs;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ShortestPathDAG extends BaseGraph {

    public static int[] path;
    public static void main(String[] args) {
        InputStream ip;
        V = 6;
        weightedAdjList = new ArrayList<>();
        for (int i=0; i<V; i++) {
            weightedAdjList.add(new ArrayList<>());
        }
        addWeightedDirectedEdge(0, 1, 2);
        addWeightedDirectedEdge(1, 2, 3);
        addWeightedDirectedEdge(0, 4, 1);
        addWeightedDirectedEdge(4, 2, 2);
        addWeightedDirectedEdge(2, 3, 6);
        addWeightedDirectedEdge(5, 3, 1);
        addWeightedDirectedEdge(4, 5, 4);
        path = new int[V];
        int source = 0;
        for (int i=0; i<V; i++) {
            path[i] = -1;
        }
        path[source] = 0;
        shortestPath(weightedAdjList, 0);
        for (int i=0; i<V; i++) {
            System.out.println(i + " --> " + path[i]);
        }
    }

    private static void shortestPath(List<List<Pair>> mgraph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int ss = queue.poll();
            List<Pair> list = mgraph.get(ss);
            for (Pair p: list) {
                if (path[p.a] == -1) {
                    path[p.a] = path[ss] + p.b;
                } else {
                    path[p.a] = Math.min(path[p.a], path[ss] + p.b);
                }
                queue.add(p.a);
            }
        }
    }
}
