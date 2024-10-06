package org.example.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("sample");
        setSize(960, 540); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setVisible(true);

        startGame();
    }

    public void startGame() {
        MainMenu main = new MainMenu();
        setContentPane(main);
    }
}
