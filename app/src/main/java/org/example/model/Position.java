package org.example.model;

import lombok.Getter;

@Getter
@Setter
public class Position {
    private String filepath;

    public Position() {
        this.filepath = "";
    }
}
