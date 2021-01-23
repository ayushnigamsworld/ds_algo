package contest_7thOct;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class GridlandMetro {

    // Complete the gridlandMetro function below.
    static String gridlandMetro(int n, int m, int k, int[][] track) {
        BigInteger nB = new BigInteger(String.valueOf(n));
        BigInteger resultB = nB.multiply(new BigInteger(String.valueOf(m)));
        if(k == 0) {
            return resultB.toString();
        }
        BigInteger trackSumB = new BigInteger("0");
        Map<Integer, List<Pair>> sameRowMap = new HashMap<>();
        for (int tracker =0; tracker<k; tracker++) {
            if (sameRowMap.containsKey(track[tracker][0])) {
                sameRowMap.get(track[tracker][0]).add(new Pair(track[tracker][1], track[tracker][2]));
            } else {
                List<Pair> pairList = new ArrayList<>();
                pairList.add(new Pair(track[tracker][1], track[tracker][2]));
                sameRowMap.put(track[tracker][0], pairList);
            }
        }
        for (Map.Entry<Integer,List<Pair>> entry : sameRowMap.entrySet()) {
            List<Pair> pp = entry.getValue();
            long trackSum = mergeTotal(pp);
            trackSumB = trackSumB.add(new BigInteger(String.valueOf(trackSum)));
        }
        // Collection<List<Pair>> pairLists = sameRowMap.values();
        // for (List<Pair> pp: pairLists) {
        //     trackSum += mergeTotal(pp);
        // }
        return resultB.subtract(trackSumB).toString();

    }

    static long mergeTotal(List<Pair> list) {
        long mergeTotal = 0;
        if ( list == null || list.isEmpty()) {
            return 0;
        }
        if (list.size() == 1) {
            mergeTotal += (list.get(0).end - list.get(0).start + 1);
            return mergeTotal;
        }
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair left, Pair right)  {
                return left.start - right.start;
            }
        });
        Stack<Pair> stack = new Stack<>();
        stack.push(list.get(0));
        for (int i = 1 ; i < list.size(); i++) {
            // get interval from stack top
            Pair top = stack.peek();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < list.get(i).start)
                stack.push(list.get(i));

                // Otherwise update the ending time of top if ending of current
                // interval is more
            else if (top.end < list.get(i).end)
            {
                top.end = list.get(i).end;
                stack.pop();
                stack.push(top);
            }
        }
        while (!stack.isEmpty()) {
            Pair t = stack.pop();
            mergeTotal += (t.end - t.start + 1);
        }

        return mergeTotal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        String result = gridlandMetro(n, m, k, track);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

class Pair {
    int start;
    int end;
    Pair(int start, int end) {
        this.start= start;
        this.end = end;
    }
}
