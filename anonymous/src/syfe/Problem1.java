package syfe;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return the ordering of courses you should take to finish all courses.
 If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 Example 2:

 Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 Output: [0,2,1,3]
 Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */

public class Problem1 {

    public static void main(String[] args) {
          int numCourses = 4;
          int[][] input = {{0, 1}, {2, 0}, {3, 1}, {3, 2}};
            int[] rr = findOrder(numCourses, input);
            for (int i=0; i<rr.length; i++) {
                System.out.println(rr[i]);
            }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int res[] = new int[numCourses];
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Set<Integer> cache = new HashSet<>();
        // Step 1 : check for circular dependency
        if (checkCircular(prerequisites)) {
            return new int[0];
        }

        // step 2: initialize the dependency graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<prerequisites.length; i++) {
            int dependent = prerequisites[i][1];
            int dependecy = prerequisites[i][0];
            cache.add(dependecy);
            if (graph.containsKey(dependent)) {
                List<Integer> ll = graph.get(dependent);
                ll.add(dependecy);
            } else {
                List<Integer> ll = new ArrayList<>();
                ll.add(dependecy);
                graph.put(dependent, ll);
            }
        }

        // step 3 find all courses with 0 dependency.
        List<Integer> zeroDependency = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            if (!cache.contains(i)) {
                zeroDependency.add(i);
            }
        }

        // step4: traverse from zero to find other dependencies using q
        for (Integer start: zeroDependency) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                result.add(current);
                if (graph.containsKey(current)) {
                    List<Integer> dependents = graph.get(current);
                    for (Integer d: dependents) {
                        queue.add(d);
                    }
                } else {
                    break;
                }
            }
        }
        int cnt=0;
        for (Integer i: result) {
            res[cnt] = i;
        }
        return res;
    }

    private static boolean checkCircular(int[][] prerequisites) {
        // TODO
        return false;
    }
}
