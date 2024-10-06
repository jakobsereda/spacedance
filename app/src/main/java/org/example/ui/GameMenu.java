package org.example.ui;

import org.example.model.Difficulty;
import org.example.model.Game;
import org.example.model.Position;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameMenu extends JPanel implements ActionListener {
    private MainFrame parent;
    private ImageIcon backgroundImage;
    private JButton quitButton;
    private Game game;
    private Timer imageSwitchTimer;
    private Timer countdownTimer;
    private JLabel imageLabel;
    private JLabel timerLabel;
    private int countdown;
    private int initCountdown;
    private Position currentPosition;

    private double pyOut;

    public GameMenu(Difficulty difficulty, MainFrame parent) throws Exception {
        this.parent = parent;
        setLayout(new BorderLayout(0, 70));
        backgroundImage = new ImageIcon("app/src/main/resources/images/bgimages/marsbackground.png");
        game = new Game(difficulty, 5);
        
        switch (difficulty) {
            case Difficulty.Easy:
                initCountdown = 30;
                break;
            case Difficulty.Medium:
                initCountdown = 15;
                break;
            case Difficulty.Hard:
                initCountdown = 7;
                break;
            default:
                throw new IllegalArgumentException("Unexpected difficulty");
        }

        JPanel positionPanel = initPositionPanel();
        add(positionPanel, BorderLayout.CENTER);

        setSize(960, 960);
        repaint();
        
        initButtons();

        countdown = initCountdown;
        setupTimers();
    }

    // Initialize buttons (e.g., quit button)
    public void initButtons() {
        Color buttonColor = new Color(200, 40, 10);
        quitButton = new JButton(" Quit ");
        initButton(quitButton, buttonColor, 300, 80, 20);
        add(quitButton, BorderLayout.SOUTH);
    }

    public JPanel initPositionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        imageLabel = new JLabel();
        timerLabel = new JLabel("30", SwingConstants.CENTER);
        timerLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        timerLabel.setForeground(Color.WHITE);

        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(timerLabel, BorderLayout.SOUTH);

        return panel;
    }

    // Display the image for the current position
    public void displayImage(Position position) {
        if (position != null) {
            ImageIcon imageIcon = new ImageIcon(position.getFilePath());
            imageLabel.setIcon(imageIcon);
        }
    }

    private void setupTimers() {
        imageSwitchTimer = new Timer(initCountdown * 1000, e -> switchImage());
        countdownTimer = new Timer(1000, e -> updateCountdown());

        imageSwitchTimer.start();
        countdownTimer.start();

        switchImage();
    }

    public void displayTimer() {
        timerLabel.setText(String.valueOf(countdown));
    }

    private void updateCountdown() {
        countdown--;
        if (countdown == 7) {
            runPythonScript(); 
        }
        if (countdown <= 0) {
            countdown = initCountdown;
            switchImage();
        }
        displayTimer();
    }

    private void runPythonScript() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python3", "path/to/your/script.py");
            processBuilder.redirectErrorStream(true);
    
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    pyOut = Double.parseDouble(line);
                } catch (NumberFormatException e) {
                    System.err.println("Could not parse output: " + line);
                }
            }
    
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Python script exited with error code: " + exitCode);
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    private void switchImage() {
        currentPosition = game.eatPosition();
        if (currentPosition != null) {
            displayImage(currentPosition);
        } else {
            imageSwitchTimer.stop();
            countdownTimer.stop();
            parent.startGame();
        }
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
        if (e.getSource() == quitButton) {
            parent.quitGame();
        }
    }
}