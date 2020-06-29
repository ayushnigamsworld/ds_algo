package Matrix;

public class Snake {
    public static void main(String[] args) {
        snake();
    }
    private static void snake() {
        int mat[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i=0; i<mat.length; i++) {
            if (i%2==0) {
                for (int j=0; j<mat[i].length; j++) {
                    System.out.print(mat[i][j]);
                }
            } else {
                for (int j=mat[i].length-1; j >=0; j--) {
                    System.out.print(mat[i][j]);
                }
            }
        }
    }
}
