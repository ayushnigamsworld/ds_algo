package recursion.backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;
        sudoku(board);
    }

    private static boolean sudoku(int matrix[][]) {
        Cell emptyCell = findEmptyCell(matrix);
        if (emptyCell == null) {
            return true;
        }
        for (int i=1; i<=9; i++) {
            if (isSafe(matrix, emptyCell.row, emptyCell.col, i)) {
                matrix[emptyCell.row][emptyCell.col] = i;
                if (sudoku(matrix)) {
                    return true;
                }
                matrix[emptyCell.row][emptyCell.col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int matrix[][], int row, int col, int n) {
        // checking if same row or col has same chosen n.
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][row] == n || matrix[col][i] == n) {
                return false;
            }
        }
        // checking in the same box, if same n is present.
        int N = matrix.length;
        int divisor = (int)Math.sqrt(N);
        int boxRow = row/divisor;
        int boxCol = col/divisor;
        for (int i=boxRow*3; i<boxRow*3 + divisor - 1; i++) {
            for (int j=boxCol*3; j<boxCol*3 + divisor - 1; j++) {
                if (matrix[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Cell findEmptyCell(int matrix[][]) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }
}

class Cell {
    int row;
    int col;
    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
