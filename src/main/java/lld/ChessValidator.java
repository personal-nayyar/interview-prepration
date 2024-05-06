package lld;

import jdk.jshell.spi.SPIResolutionException;
import org.springframework.web.servlet.tags.EscapeBodyTag;

public class ChessValidator {
}
class ChessPlayer{
    String id;
    boolean white;
}

abstract class Piece{
    boolean isWhite;
    Piece(boolean isWhite){}
    abstract boolean validateMove(int srcX, int srcY, int desX, int desY);
}

class King extends Piece{
    King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean validateMove(int srcX, int srcY, int desX, int desY) {
        return false;
    }
}
class Queen extends Piece{
    Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean validateMove(int srcX, int srcY, int desX, int desY) {
        return false;
    }
}
class Knight extends Piece{
    Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean validateMove(int srcX, int srcY, int desX, int desY) {
        return false;
    }
}
class Rook extends Piece{
    Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean validateMove(int srcX, int srcY, int desX, int desY) {
        return false;
    }
}
class Bishop extends Piece{
    Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean validateMove(int srcX, int srcY, int desX, int desY) {
        return false;
    }
}
class Pawn extends Piece{
    boolean firstMove;

    Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean validateMove(int srcX, int srcY, int desX, int desY) {
        if (isWhite){
            if (srcY != desY)
                return false;
            if (srcX+1  != desX || srcX+2 != desX && this.firstMove)
                return false;
        }
        return true;
    }
}

class Cell{
    int row;
    int col;
    Piece piece;
}

class ChessBoard{
    int size = 8;
    ChessPlayer[] players;
    Cell[][] cells;

    ChessBoard(){
        players = new ChessPlayer[2];
        cells = new Cell[size][size];
        initialize(true);
        initialize(false);
    }

    void initialize(boolean isWhile){
        Piece king  = new King(isWhile);
        Piece queen = new Queen(isWhile);
        Piece knight = new Knight(isWhile);
        Piece knight2 = new Knight(isWhile);
        // for other
        cells[0][4].piece = king;
        cells[0][3].piece = queen;
        cells[0][1].piece = knight;
        cells[0][6].piece = knight2;
        // for other
    }

    void move(int srcX, int srcY, int desX, int desY){
        Piece piece = cells[srcX][srcY].piece;

        // validate move
        piece.validateMove(srcX, srcY, desX, desY);

        // make move

        // update board

        // update player

    }

}