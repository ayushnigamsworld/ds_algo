package arrays.binary_search.discrete_binary_search;

import java.util.Arrays;

/**
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls.
 * The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall.
 * To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls,
 * such that the minimum distance between any two of them is as large as possible.
 * What is the largest minimum distance?
 *
 * https://www.spoj.com/problems/AGGRCOW/
 */
public class AggressiveCows {

    public static void main(String[] args) {
        int barns[] = {1, 2, 8, 4, 9};
        int cows = 3;
        Arrays.sort(barns);
        int res = findLargestMinDist(0, barns[barns.length - 1], cows, barns);
        System.out.println(res);
    }

    /**
     * Finding LAST Yes. As of discrete binary search.
     */
    private static int findLargestMinDist(int l, int r, int cows, int barns[]){
        while (l < r) {
            int mid = l + (r - l + 1)/2; // Always taking ceiling.
            boolean fx = isThisPositionGood(barns, cows, mid);
            if (fx) {
                l = mid;

            }else {
                r = mid - 1;
            }
        }
        return l;
    }

    private static boolean isThisPositionGood(int barns[], int cow, int x) {
        // assuming first cow on the first barn always.
        int current = 1;
        int prev = 0;
        cow--;
        while (current < barns.length && cow > 0) {
            if (barns[current] - barns[prev] >= x) {
                prev = current;
                cow--;
            }
            current++;
        }
        return cow == 0;
    }
}
