package org.example.ui;

import javax.swing.*;

import org.example.model.Difficulty;
import org.example.model.Game;

public class GameMenu extends JPanel {
    private JButton quitButton;
    private Game game;

    public GameMenu(Difficulty difficulty, int numPositions) {
        game = new Game(difficulty,numPositions);
    }

    //TODO method to display image

    //TODO display timer
    //TODO quit game
}
