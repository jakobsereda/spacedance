package org.example.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {
    private MainFrame parent;
    private ImageIcon backgroundImage;
    private JButton quitButton;
    private JButton easyButton;
    private JButton mediButton;
    private JButton hardButton;

    public MainMenu(MainFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout(0, 70));
        backgroundImage = new ImageIcon("app/src/main/resources/images/bgimages/spacebackground.jpg");

        JPanel buttonPanel = initButtons();

        JPanel spacing = new JPanel();
        spacing.setOpaque(false);

        setSize(960, 960);
        add(spacing, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        repaint();
    }

    private JPanel initButtons() {
        Color buttonColor = new Color(200, 40, 10); // change this pleaseeeee

        quitButton = new JButton(" Quit ");
        initButton(quitButton, buttonColor, 200, 80, 15);

        easyButton = new JButton(" Start Easy Game ");
        initButton(easyButton, buttonColor, 200, 80, 15);

        mediButton = new JButton(" Start Medium Game ");
        initButton(mediButton, buttonColor, 200, 80, 15);

        hardButton = new JButton(" Start Hard Game ");
        initButton(hardButton, buttonColor, 200, 80, 15);

        return initButtonPanel();
    }

    private JPanel initButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);

        JPanel firstButtonRow = new JPanel();
        firstButtonRow.setOpaque(false);

        JPanel secondButtonRow = new JPanel();
        secondButtonRow.setOpaque(false);

        FlowLayout buttonManager = new FlowLayout();
        buttonManager.setHgap(40);

        firstButtonRow.setLayout(buttonManager);
        secondButtonRow.setLayout(buttonManager);
        firstButtonRow.add(easyButton);
        firstButtonRow.add(mediButton);
        firstButtonRow.add(hardButton);
        secondButtonRow.add(quitButton);
        buttonPanel.add(firstButtonRow);
        buttonPanel.add(secondButtonRow);
        return buttonPanel;
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

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Dimension d = getSize();
        graphics.drawImage(backgroundImage.getImage(), 0, 0, d.width, d.height, this);
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
