package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given adjacency list representation, do a BFS,
 * BFS is where closer edges get printed first, then farther edges are printed
 */
public class BFS extends BaseGraph {

    /**
     *    1---3---4
     *    |
     *    2---5
     */

    private static boolean[] visited;
    public static void main(String[] args) {
        int V= 6;
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            mygraph.add(new ArrayList<>());
        }
        visited = new boolean[V+1];
        addEdge(1, 3, mygraph);
        addEdge(1, 2, mygraph);
        addEdge(3, 4, mygraph);
        addEdge(2, 5, mygraph);
        printBFS(mygraph, 1);
    }

    private static void printBFS(List<List<Integer>> mygraph, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(sourceNode);
        visited[sourceNode] = true;
        queue.add(sourceNode);
        while (!queue.isEmpty()) {
            List<Integer> neighbors = mygraph.get(queue.poll());
            for (Integer n: neighbors) {
                if (!visited[n]) {
                    queue.add(n);
                    System.out.println(n);
                    visited[n] = true;
                }
            }
        }
    }
}
