package lld;

import lombok.AllArgsConstructor;

public class TicTacToe {
    GameStatus gameStatus;
    BoardTicTacToe board;
    PlayerTicTacToe[] playerTicTacToes;

}

@AllArgsConstructor
enum Symbol{
    X(1),
    O(-1);
    final int val;
}
class PlayerTicTacToe{
    int id;
    Symbol symbol;
}

class MoveTicTacToe{
    int row;
    int col;
}

class BoardTicTacToe{
    int size = 3;
    Symbol[][] cells;

    BoardTicTacToe(){
        cells = new Symbol[3][3];
    }

    // validate move

    // makeMove

    // check Win move
}

