package Matrix;

public class SearchSorted {

    public static void main(String[] args) {
        searchSorted(15);
    }

    static void searchSorted(int search) {
        int mat[][] = { {10, 20, 30},
                        {15, 25, 80},
                        {35, 90, 100}};
        int rows = 0;
        int cols = mat[rows].length - 1;

        while (rows < mat.length && cols >= 0) {
            if (mat[rows][cols] == search) {
                System.out.println("---> ");
                break;
            }
            else if (mat[rows][cols] < search) {
                rows++;
            } else {
                cols--;
            }
        }
    }
}
