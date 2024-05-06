package lld;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg
 */
public class SnakeAndLadder {
}

class Player{
    int id;
    int pos;
}
class Dice{

    int roll() {
        return (int) (Math.random() * 6) +1;
    }
}
class Board{
    int size = 101;
    int[] cells;
    Snake[] snakes;
    Ladder[] ladders;

    Board(Snake[] snakes, Ladder[] ladders){
        cells = new int[size];
        this.snakes= snakes;
        this.ladders = ladders;
    }
}
abstract class Move{
    int start;
    int end;
    abstract void validate();
}
class Snake extends Move{
    @Override
    void validate() {

    }
}
class Ladder extends Move{

    @Override
    void validate() {

    }
}

enum GameStatus{
    NOT_STARTED,
    PLAYING,
    WON
}
class GameService{
    Dice dice;
    Board board;
    Queue<Player> players;
    Map<Integer, Integer> snakeLadderMap;

    GameService(Snake[] snakes, Ladder[] ladders){
        dice =  new Dice();
        board = new Board(snakes, ladders);
        players = new LinkedList<>();
        snakeLadderMap = new HashMap<>();
        for (Snake snake: snakes){
            snakeLadderMap.put(snake.start, snake.end);
        }
        for (Ladder ladder: ladders){
            snakeLadderMap.put(ladder.start, ladder.end);
        }
    }

    // add User

    // start game

    // make move

    // play(Player p)
    void play(Player p){
        // make move
        // add player to the last
        players.add(p);
    }

    void move(Player p, int score){
        int curr = p.pos;
        int nextPos = (curr+score)%100;

        //check if special move
        if (snakeLadderMap.containsKey(nextPos))
            nextPos =  snakeLadderMap.get(nextPos);
        p.pos = nextPos;

        // check if win
        if (p.pos ==  100){
            // perform game win by p
        }
    }

}


