package medium.search_sort;

import java.util.Arrays;

public class Search2DMatrix1 {

    public static void main(String[] args) {
        int[][] inp = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 20;
        System.out.println(new Search2DMatrix1().search2D1(inp, target));
    }

    public boolean search2D1(int[][] mat, int target) {
        if (target < mat[0][0] || target > mat[mat.length-1][mat[0].length-1]) {
            return false;
        }
        int row = mat.length-1;
        for (int i=1; i<mat.length; i++) {
            if (target < mat[i][0]) {
                row = i-1;
                break;
            }
        }
        if (row == -1) return false;
        int res = Arrays.binarySearch(mat[row], target);
        return res >= 0;
    }
}
