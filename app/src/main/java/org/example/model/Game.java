package org.example.model;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Getter;

// Represents a gameplayed by the user
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

    public Position EatPosition() {
        return positions.remove();
    }


}
