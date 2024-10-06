package org.example;

import org.example.model.Difficulty;
import org.example.model.Game;
import org.example.model.HighScoreManager;
import org.example.ui.MainFrame;

public class App {
    public static void main(String[] args) {
        new MainFrame();
        Game test = new Game(Difficulty.Easy, 5);
        test.gameEnd();
    }
}
