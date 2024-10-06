package org.example.ui;

import java.awt.BorderLayout;
import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("sample");
        setSize(960, 540); 
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

    }

    public void mediGame() {

    }

    public void hardGame() {

    }
}
