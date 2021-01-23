package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountIslands {

    /**
     *    1---3---4     6---7   9---10
     *    |                 |
     *    2---5             8
     */

    private static boolean[] visited;
    public static void main(String[] args) {
        int V= 10;
        List<List<Integer>> mygraph = new ArrayList<>();
        for (int i=0; i<V+1; i++) {
            mygraph.add(new ArrayList<>());
        }
        visited = new boolean[V+1];
        addEdge(1, 3, mygraph);
        addEdge(1, 2, mygraph);
        addEdge(3, 4, mygraph);
        addEdge(2, 5, mygraph);
        addEdge(6, 7, mygraph);
        addEdge(7, 8, mygraph);
        addEdge(9, 10, mygraph);
        System.out.println(countDisconnectedGraphs(mygraph, V));
    }

    private static void addEdge(int a, int b, List<List<Integer>> adjacencyList) {
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
    }

    private static void doBFS(List<List<Integer>> mygraph, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceNode] = true;
        queue.add(sourceNode);
        while (!queue.isEmpty()) {
            List<Integer> neighbors = mygraph.get(queue.poll());
            for (Integer n: neighbors) {
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    private static int countDisconnectedGraphs(List<List<Integer>> mygraph, int V) {
        int count =0;
        for (int i=1; i<V+1; i++) {
            doBFS(mygraph, i);
            for (int j=1; j<V+1; j++) {
                if (!visited[j]) {
                    count++;
                    i = j-1;
                    break;
                }
            }
        }
        return count+1;
    }
}
