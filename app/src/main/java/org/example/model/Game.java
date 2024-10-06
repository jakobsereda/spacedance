package org.example.model;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

// Represents a game played by the user
public class Game {
    private Difficulty difficulty;
    private Queue<Position> positions;
    private int score = 0;

    public Game(Difficulty difficulty, int numPositions) {
        this.difficulty = difficulty;
        positions = new LinkedList<>();
        score = 0;

        for (int i = 0; i < numPositions; i++) {
            positions.add(new Position());
        }
    }

    public Position eatPosition() {
        return positions.remove();
    }

    private int increaseScore(int scorePlus){
        return this.score += scorePlus;
    }

    public void gameEnd(){
        HighScoreManager manager = new HighScoreManager();
        String playerName = manager.getName();
        manager.addPrintScore(playerName, this.score);
    }
}
