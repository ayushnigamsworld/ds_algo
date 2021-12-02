package medium.search_sort;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
 */
public class Search2DMatrix_II {

    public static void main(String[] args) {
        int[][] inp = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Search2DMatrix_II search2DMatrix_ii = new Search2DMatrix_II();
        int target = 26;
        System.out.println(search2DMatrix_ii.searchInMatrix(inp, target));
    }

    private boolean searchInMatrix(int[][] inp, int target) {
        int max = Math.max(inp.length-1, inp[0].length-1);
        int diagonalIndex = binaryDiagonal(0, max, inp, target);
        if (inp[diagonalIndex][diagonalIndex] == target) {
            return true;
        }
        int foundIndex = Arrays.binarySearch(inp[diagonalIndex], 0, diagonalIndex, target);
        if (foundIndex >= 0) {
            return true;
        } else {
            for (int i=0; i<diagonalIndex; i++) {
                if (inp[i][diagonalIndex] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private int binaryDiagonal(int low, int high, int[][] inp, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        int actualMid = inp[mid][mid];
        if (actualMid == target
                || (mid != 0 && actualMid > target && inp[mid-1][mid-1] < target)) {
            return mid;
        }
        else if (actualMid < target) {
            return binaryDiagonal(mid+1, high, inp, target);
        }
        return binaryDiagonal(low, mid-1, inp, target);
    }
}
