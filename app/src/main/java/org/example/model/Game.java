package org.example.model;

import java.util.List;

import lombok.Getter;

@Getter
// Represents a gameplayed by the user
public class Game {
    private Difficulty difficulty;
    private List<Position> positions;
}
