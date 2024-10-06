//package org.example.model;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//// Represents a game played by the user
//public class Game {
//    private Difficulty difficulty;
//    private Queue<Position> positions;
//    private int score;
//
//    public Game(Difficulty difficulty, int numPositions) {
//        this.difficulty = difficulty;
//        positions = new LinkedList<>();
//        for (int i = 0; i < numPositions; i++) {
//            positions.add(new Position());
//        }
//    }
//
//    public Position eatPosition() {
//        return positions.remove();
//    }
//
//
//}

package org.example.model;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private Difficulty difficulty;
    private Queue<Position> positions;
    private int score = 0;
    private int timeLimit;  // Time limit for each position in milliseconds
    private Timer gameTimer;

    // Swing components for UI
    private JFrame frame;
    private JLabel imageLabel;
    private JLabel scoreLabel;

    public Game(Difficulty difficulty, int numPositions, int timeLimit) {
        this.difficulty = difficulty;
        this.timeLimit = timeLimit;
        positions = new LinkedList<>();

        // Add random positions to the queue (can customize based on difficulty)
        for (int i = 0; i < numPositions; i++) {
            positions.add(new Position());
        }

        // Setup Swing UI
        setupUI();

        // Start the game loop
        startGame();
    }

    // Method to remove and return the next position in the queue
    public Position eatPosition() {
        return positions.poll();  // Use poll() instead of remove() to avoid exceptions
    }

    // Method to start the game loop
    private void startGame() {
        gameTimer = new Timer();
        showNextPosition();
    }

    // Show the next position's image and start the timer for the user to match it
    private void showNextPosition() {
        Position currentPosition = eatPosition();

        if (currentPosition == null) {
            // Game over
            JOptionPane.showMessageDialog(frame, "Game Over! Your final score: " + score);
            gameTimer.cancel();
            return;
        }

        // Load the image for the current position (add actual image logic)
        ImageIcon image = new ImageIcon("path_to_image_based_on_position.jpeg");
        imageLabel.setIcon(image);

        // Start the timer for the user to match the position
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Placeholder: check if user matches the position using camera input
                boolean correctPosition = checkUserPosition(currentPosition);
                if (correctPosition) {
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
                showNextPosition();  // Show the next position after the time limit expires
            }
        }, timeLimit);
    }

    // Placeholder method for pose matching logic
    private boolean checkUserPosition(Position position) {
        // Implement camera recognition logic here
        // For now, simulate with a random result
        return Math.random() > 0.5;
    }

    // Method to set up the Swing UI components
    private void setupUI() {
        frame = new JFrame("Pose Matching Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel("", SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: 0", SwingConstants.LEFT);

        frame.add(imageLabel, BorderLayout.CENTER);
        frame.add(scoreLabel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Difficulty difficulty = Difficulty.Easy;  // Set difficulty parameters
        int numPositions = 5;
        int timeLimit = 5000;  // 5 seconds to match each position

        new Game(difficulty, numPositions, timeLimit);
    }
}

