package Matrix;

public class SpiralTraversal {
    public static void main(String[] args) {
        spiral();
    }
    static void spiral() {
        int mat[][] = { { 1,   2,  3,  4 },
                        { 5,   6,  7,  8 },
                        { 9,  10, 11, 12 },
                        {13,  14, 15, 16}};

        int row = 0; int col = 0;
        int total = 0;
        while (total <= (mat.length/2)) {
            while (col < (mat[0].length - total)) {
                System.out.print(mat[row][col] + " ");
                col++;
            }
            col--; row++;
            while (row < (mat.length - total)) {
                System.out.print(mat[row][col] + " ");
                row++;
            }
            row--; col--;
            while (col >= (0 + total)) {
                System.out.print(mat[row][col] + " ");
                col--;
            }
            col++; row--;
            while (row > (0+total)) {
                System.out.print(mat[row][col] + " ");
                row--;
            }
            row++; col++;
            total++;
        }

    }
}
