package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath extends BaseGraph {

    private static boolean visited[];
    private static int distance[];
    /**
     *    1---2---3---4
     *    \      /
     *     ------
     */
    public static void main(String[] args) {
        int V= 6;
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
        visited = new boolean[V+1];
        distance = new int[V+1];
        for (int i=0; i<V+1; i++) {
            distance[i] = -1;
        }
        addEdge(1, 2, mygraph);
        addEdge(1, 3, mygraph);
        addEdge(3, 4, mygraph);
        addEdge(2, 3, mygraph);
        shortestPath(mygraph, 1);
        for (int i=1; i<V+1; i++) {
            System.out.println(i + " -> " + distance[i]);
        }
    }

    private static void shortestPath(List<List<Integer>> mygraph, int s) {
        visited[s] = true;
        distance[s] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(s, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int countP = p.b;
            countP++;
            List<Integer> neighbor = mygraph.get(p.a);
            for (Integer nn: neighbor) {
                if (!visited[nn]) {
                    queue.add(new Pair(nn, countP));
                    if (distance[nn] == -1) {
                        distance[nn] = countP;
                    } else {
                        distance[nn] = Math.min(countP, distance[nn]);
                    }
                }
                visited[nn]= true;
            }
        }
    }
}

