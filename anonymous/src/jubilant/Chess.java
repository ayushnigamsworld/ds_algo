package jubilant;

public class Chess {


}


// represents one cell of the chess 8 * 8
class Block {
    private Piece piece;
    private int x;
    private int y;
    Block(Piece piece, int x, int y) {
        //
    }
}

// represents Chess pieces | abstract class
interface Piece {
    static boolean black = false;
    boolean isKilled = false;
    boolean moveAllowed(Board b, Block start, Block end);
    // void move(Board b, Block start, Block end);
}

class King implements Piece {

    @Override
    public boolean moveAllowed(Board b, Block start, Block end) {
        // rules
         return false;
        // return true if not occupied
        // step to check if end has piece of same color, return false
        // step if end - start check
        // step boundaries 0 < x < 8
    }
}

class Queen implements Piece {

    @Override
    public boolean moveAllowed(Board b, Block start, Block end) {
        return false;
    }
}

abstract class Player {
    private boolean black = false;
    // name level
}

class Robot extends Player {

}

class Human extends Player {

}

class Board {
    private Block[][] blocks;

    // init
    Board() {
        blocks[0][0] = new Block(new King(), 0, 1);

        for (int row = 2; row<5; row++) {
            for (int column =2; column < 5; column++) {
                // blocks[row][column] = new Block(row, column);
            }
        }


    }
}

class Move {
    private Piece piece;
}

class Game {
    Player p1;
    Player p2;
    Board b1;
    Move currentMove;
}