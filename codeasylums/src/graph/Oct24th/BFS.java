package graph.Oct24th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int V  = 4;
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
        adjList.get(0).add(1);
        adjList.get(0).add(4);
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(1).add(4);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
    }

    private static void bfs(List<List<Integer>> adjList) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(adjList.get(0));
        while (!queue.isEmpty()) {
            List<Integer> ls = queue.poll();
            for (Integer a: ls) {
                System.out.println(a);
            }
        }
    }
}
