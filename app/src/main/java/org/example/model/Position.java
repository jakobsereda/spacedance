package org.example.model;

import lombok.Getter;

@Getter
public class Position {
    private String filepath;

    public Position(String filepath) {
        this.filepath = filepath;
    }

    // Randomized Position Constructor
    public Position() {
        this.filepath = "";
    }
}
