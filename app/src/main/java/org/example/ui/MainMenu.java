package org.example.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {
    private JButton quitButton;
    private JButton easyButton;
    private JButton mediButton;
    private JButton hardButton;

    public MainMenu() {

    }

    /**
     * Initializes a JButton to given specs
     * 
     * @param button 
     */
    public void initButton(JButton button, Color buttonColor, int width, int height, int fontSize) {
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(buttonColor);
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.WHITE));
        button.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(quitButton)) {
            // do something...
        } else if (e.getSource().equals(easyButton)) {
            // do something else...
        } else if (e.getSource().equals(mediButton)) {
            // do semething again...
        } else if (e.getSource().equals(hardButton)) {
            // ...
        } 
    }
}
