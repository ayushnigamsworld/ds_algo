package recursion.backtracking;

public class NQueen {
    public static void main(String[] args) {
        int N = 4;
        boolean inp[][] = new boolean[N][N];
        nQueen(inp, 0, N);
        printChess(inp, N);
    }

    /**
     * Recursively moving column-wise
     * But actually finding correct row to place this queen , iteratively moving row-wise.
     */
    private static boolean nQueen(boolean arr[][], int col, int N) {
        if (col >= N) {
            return true;
        }
        for (int row=0; row<N; row++) {
            if (isSafe(arr, row, col, N)) {
                System.out.println("--- Accepting "+ row + " " + col);
                arr[row][col] = true;
                printChess(arr, N);
                if (nQueen(arr, col + 1, N)) {
                    return true;
                }
                System.out.println("$$--- Backtracking ---$$");
                arr[row][col] = false;
            } else {
                System.out.println("--- Rejecting "+ row + " " + col);
            }
        }
        return false;
    }

    private static boolean isSafe(boolean arr[][], int row, int col, int N) {
        // checking on left side of this position, as moving col wise,
        for (int i=0; i<col; i++) {
            if (arr[row][i]) {
                System.out.println("Lies on same row");
                return false;
            }
        }
        int ncol = col-1, nrow = row-1;
        while (ncol >= 0 && nrow >= 0) {
            if (arr[nrow][ncol]) {
                System.out.println("Lies on same upper left diagonal");
                return false;
            }
            ncol--;
            nrow--;
        }
        int lcol = col-1, lrow = row + 1;
        while (lcol >= 0 && lrow < N) {
            if (arr[lrow][lcol]) {
                System.out.println("Lies on same lower left diagonal");
                return false;
            }
            lrow++;
            lcol--;
        }
        return true;
    }

    private static void printChess(boolean arr[][], int N) {
        System.out.println("-----------------------");
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }
}
