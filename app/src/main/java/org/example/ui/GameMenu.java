package org.example.ui;
import org.example.Timer;

import javax.swing.*;
import javax.swing.border.LineBorder;

import org.example.model.Difficulty;
import org.example.model.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel implements ActionListener {
    private MainFrame parent;
    private JButton quitButton;
    private Game game;
    private Timer time;

    public GameMenu(Difficulty difficulty) {
        game = new Game(difficulty, 5);
        time = new Timer();
    }

    public void initButtons() {
        Color buttonColor = new Color(White);
        quitButton = new JButton(" Quit ");
        initButton(quitButton, buttonColor, 300, 80, 20);
    }

    //TODO method to display image
    public void displayImage(){

    }
    
    //TODO display timer
    public void displayTimer(){

    }

    /**
     * Initializes a JButton to given specs
     * 
     * @param button 
     */
    private void initButton(JButton button, Color buttonColor, int width, int height, int fontSize) {
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(buttonColor);
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.WHITE));
        button.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        button.addActionListener(this);
    }
    
    //TODO quit game
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
