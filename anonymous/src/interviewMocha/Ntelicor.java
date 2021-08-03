package interviewMocha;

import java.util.*;

public class Ntelicor {

    private static Map<Integer, List<Integer>> mp = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();
    public static void main(String[] args) {
        int n = 5;
        int nodes[][] = new int[n][2];
        nodes[0][0] = 1;
        nodes[0][1] = 12;
        nodes[1][0] = 1;
        nodes[1][1] = 4;
        nodes[2][0] = 12;
        nodes[2][1] = 3;
        nodes[3][0] = 3;
        nodes[3][1] = 5;
        nodes[4][0] = 4;
        nodes[4][1] = 6;
        init(n, nodes);
        heavy(1);
    }

    private static void init(int n, int coordinates[][]) {
        for (int i=0; i<n; i++) {
            int key = coordinates[i][0];
            int value = coordinates[i][1];
            visited.add(value);
            if (mp.containsKey(key)) {
                List<Integer> l = mp.get(key);
                l.add(value);
                mp.put(key, l);
            } else  {
                List<Integer> l = new ArrayList<>();
                l.add(value);
                mp.put(key, l);
            }
        }
    }

    private static int findRoot() {
        for (Integer key : mp.keySet()) {
            if (!visited.contains(key)) {
                return key;
            }
        }
        return -1;
    }

    private static void heavy(int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        System.out.println(source);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> ls = mp.get(parent);
            if (ls != null) {
                for (Integer currentElement : ls) {
                    System.out.println(currentElement);
                    queue.add(currentElement);
                }
            }
        }
    }
}
