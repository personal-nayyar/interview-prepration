package code.problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/design-an-atm-machine/description/
 Input : [[100, 2], [500, 3], [1000, 4]], 4000
 Output : 4
 Input : [[100, 2], [500, 3], [1000, 5]], 10000
 Output : "cannot dispense"

 */
public class MinNoteATM {
    public static void main(String[] args) {
        int[][] notes = new int[][]{{1000,4}, {500,3}, {100, 2}};
        System.out.println(minNotes(notes, 4000));
        /*
            1000, 4
            500,  3
            100,  2
            notes[0][0] --> 1000, notes[0][1] -> 4
            notes[1][0] -> 500
            notes[2][0] -> 100
         */
    }

    static int minNotes(int[][] notes, int amount){
        int count = 0;
        int count1000 = Math.min(amount/notes[0][0], notes[0][1]);
        amount -= notes[0][0] * count1000;
        int count500 = Math.min(amount/notes[1][0], notes[1][1]);
        amount -= notes[1][0] * count1000;
        int count100 = Math.min(amount/notes[2][0], notes[2][1]);
        amount -= notes[2][0] * count1000;
        return count1000 + count500 + count100;
    }
}
