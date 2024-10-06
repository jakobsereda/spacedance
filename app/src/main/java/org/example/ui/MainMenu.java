package org.example.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {
    private MainFrame parent;
    private JButton quitButton;
    private JButton easyButton;
    private JButton mediButton;
    private JButton hardButton;

    public MainMenu(MainFrame parent) {
        
    }

    public void initButtons() {
        Color buttonColor = new Color(0, 0, 0);

        quitButton = new JButton(" Quit ");
        initButton(quitButton, buttonColor, 300, 80, 20);

        easyButton = new JButton(" Start Easy Game ");
        initButton(easyButton, buttonColor, 300, 80, 20);

        mediButton = new JButton(" Start Medium Game ");
        initButton(mediButton, buttonColor, 300, 80, 20);

        hardButton = new JButton(" Start Hard Game ");
        initButton(hardButton, buttonColor, 300, 80, 20);
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
            parent.quitGame();
        } else if (e.getSource().equals(easyButton)) {
            parent.easyGame();
        } else if (e.getSource().equals(mediButton)) {
            parent.mediGame();
        } else if (e.getSource().equals(hardButton)) {
            parent.hardGame();
        } 
    }
}
