package Matrix;

public class  Intro {

    public static void main(String[] args) {
        intro();
    }

    private static void intro() {
        int mat[][] = {{1, 2, 3 }, {4, 5, 6, 7}};
        for (int i=0; i< mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
