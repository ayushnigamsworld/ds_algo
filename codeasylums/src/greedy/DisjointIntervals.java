package greedy;

import java.util.List;

/**
 * Given a set of N intervals denoted by 2D array A of size N x 2, the task is to find the length of maximal set of mutually disjoint intervals.
 Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.
 Return a integer denoting the length of maximal set of mutually disjoint intervals.

 Problem Constraints
 1 <= N <= 105

 1 <= A[i][0] <= A[i][1] <= 109

 A = [
 [1, 4]
 [2, 3]
 [4, 6]
 [8, 9]
 ]
 ans -> 3
 A = [
 [1, 9]
 [2, 3]
 [5, 7]
 ]
 ans -> 2

 1. Meeting rooms
 -----------------
 Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.

 Where:

 A[i][0] = start time of the ith meeting.
 A[i][1] = end time of the ith meeting.
 Find the minimum number of conference rooms required so that all meetings can be done.

 A = [      [0, 30]
 [5, 10]
 [15, 20]
 ]
 ans -> 2

 A =  [     [1, 18]
 [18, 23]
 [15, 29]
 [4, 15]
 [2, 11]
 [5, 13]
 ]
 ans -> 4
 */
public class DisjointIntervals {

     public static void main(String[] args) {
       StringBuilder stringBuilder = new StringBuilder("buffering");
       stringBuilder.replace(2, 7, "BUFFER");
       stringBuilder.delete(2,4);
       String s = stringBuilder.substring(1,5);
         System.out.println(s;

    }
}
