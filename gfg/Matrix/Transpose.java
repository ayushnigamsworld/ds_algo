package Matrix;

public class Transpose {

    public static void main(String[] args) {

    }

    static void transpose() {
        int mat[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i=0; i< mat.length; i++) {
            for (int j=i+1; j<mat[i].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}
