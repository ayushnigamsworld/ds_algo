package Matrix;

public class Rotate90 {
    public static void main(String[] args) {
        rotate();
    }
    static int[][] rotate() {
        int mat[][] = {{1, 2, 3 }, {4, 5, 6}, {7, 8, 9}};
        for (int i=0; i< mat.length; i++) {
            for (int j=i+1; j<mat[i].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i=0; i< mat.length; i++) {
            for (int j=0; j<mat[i].length/2; j++) {
                int jreverse = j + mat[i].length - 1;
                int temp = mat[j][i];
                mat[j][i] = mat[jreverse][i];
                mat[jreverse][i] = temp;
            }
        }
        return mat;
    }
}
