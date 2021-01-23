package graph;

public class RateMaze {
    public static void main(String[] args) {
        int maze[][] = {{1, 0, 1}, {1, 1, 0}, {0 ,0, 1}};
        pahuchegaKya(0, 0, maze);
    }

    /**
     * bool ratInMaze(int i,int j,int m,int n,char*maze){
     if(i==m || j==n){
     cout<<"possible";
     return true;
     }
     bool right=ratInMaze(i+1,j,m,n);
     bool left=raInMaze(i,j+1,m,n);
     if(right||left){
     return true;
     }
     return false;
     }
     * @param curRow
     * @param curCol
     * @param maze
     * @return
     */
    private static boolean pahuchegaKya(int curRow, int curCol, int maze[][]) {
        if (curRow == maze.length -1 && curCol == maze[0].length) {
            return true;
        }
        if (curRow >= maze.length || curCol >= maze[0].length) {
            return false;
        }
        boolean down = false;
        if (curRow + 1 < maze.length && maze[curRow + 1][curCol] == 1) {
            down = pahuchegaKya(curRow + 1, curCol, maze);
        }
        boolean right = false;
        if (curCol + 1 < maze[0].length && maze[curRow][curCol + 1] == 1) {
            right = pahuchegaKya(curRow, curCol + 1, maze);
        }
        return down && right;
    }
}
