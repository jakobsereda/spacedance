package org.example.ui;

import java.awt.BorderLayout;
import javax.swing.*;

import org.example.model.Difficulty;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("sample");
        setSize(960, 960); 
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setVisible(true);

        startGame();
    }

    public void startGame() {
        MainMenu main = new MainMenu(this);
        setContentPane(main);
    }

    public void quitGame() {
        this.dispose();
        System.exit(0);
    }

    public void easyGame() {
        try {
            GameMenu game = new GameMenu(Difficulty.Easy, this);
            setContentPane(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mediGame() {
        try {
            GameMenu game = new GameMenu(Difficulty.Medium, this);
            setContentPane(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hardGame() {
        try {
            GameMenu game = new GameMenu(Difficulty.Hard, this);
            setContentPane(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
