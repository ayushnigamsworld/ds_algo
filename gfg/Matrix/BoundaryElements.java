package Matrix;

/**
 *     {{00, 01, 02 },
        {10, 11, 12 },
        {20, 21, 22 }}
 *
 */
public class BoundaryElements {

    public static void main(String[] args) {
        boundary();
    }

    static void boundary() {
        int mat[][] = { {1, 2, 3 },
                        {4, 5, 6 },
                        {7, 8, 9 }};

        int row = 0; int col = 0;

        while (col < mat[0].length) {
            System.out.print(mat[row][col] + " ");
            col++;
        }
        row++;
        col--;
        while (row < mat.length) {
            System.out.print(mat[row][col]+ " ");
            row++;
        }
        col--;
        row--;
        while (col >= 0) {
            System.out.print(mat[row][col] + " ");
            col--;
        }
        col++;
        row--;
        while (row > 0) {
            System.out.print(mat[row][col]+ " ");
            row--;
        }

        /*for (int i=0; i< mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {

            }
        }*/
    }
}
