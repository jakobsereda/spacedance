package org.example.ui;
import org.example.Timer;

import javax.swing.*;

import org.example.model.Difficulty;
import org.example.model.Game;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel implements ActionListener {
    private MainFrame parent;
    private JButton quitButton;
    private Game game;
    private Timer time;

    public GameMenu(Difficulty difficulty, int numPositions) {
        game = new Game(difficulty,numPositions);
        time = new Timer();
    }

    public void initButtons() {
        Color buttonColor = new Color(White)
        quitButton = new JButton(" Quit ");
        initButton(quitButton, buttonColor, 300, 80, 20);
    }

    //TODO method to display image
    public void displayImage(){

    }
    //TODO display timer
    public void displayTimer(){

    }
    //TODO quit game
}
