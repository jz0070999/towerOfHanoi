package edu.georgiasouthern.finalprojecttowerofhanoi;

import java.util.ArrayList;
import java.util.List;

class MoveDisc {
    public int discIndex;
    public char startingRod;
    public char targetRod;

    public MoveDisc(int discIndex, char startingRod, char targetRod){
        this.discIndex = discIndex;
        this.startingRod = startingRod;
        this.targetRod = targetRod;
    }
}

public class TowerOfHanoi {

    private static final List<MoveDisc> moves = new ArrayList<>();

    public static List<MoveDisc> listOfMoves(int n, char startingRod, char targetRod, char intermediateRod){
        moves.clear();
        solve(n, startingRod, targetRod, intermediateRod);
        return new ArrayList<>(moves);
    }

        // Recursive function to solve the Tower of Hanoi puzzle
        public static void solve(int n, char startingRod, char targetRod, char intermediateRod) {
            // Base case: If there's only one disk, move it from source to target
            if (n == 1) {
                moves.add(new MoveDisc(n, startingRod, targetRod));
                return;
            }


            solve(n - 1, startingRod, intermediateRod, targetRod);
            moves.add(new MoveDisc(n, startingRod, targetRod));
            solve(n - 1, intermediateRod, targetRod, startingRod);
        }
    }
