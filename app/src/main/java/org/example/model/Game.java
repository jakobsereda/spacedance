package org.example.model;

import java.util.LinkedList;
import java.util.Queue;

// Represents a game played by the user
public class Game {
    private Difficulty difficulty;
    private Queue<Position> positions;

    public Game(Difficulty difficulty, int numPositions) {
        this.difficulty = difficulty;
        positions = new LinkedList<>();
        for (int i = 0; i < numPositions; i++) {
            positions.add(new Position());
        }
    }

    public Position eatPosition() {
        return positions.remove();
    }
}
