//package org.example.model;
//
//import javax.swing.*;
//import java.util.List;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class HighScoreManager {
//    private static final String HIGH_SCORE_FILE = "app/src/main/resources/highscores.txt";  // Path to your high score file
//
//    // Method to add a score to the high score list
//    public void addPrintScore(String playerName, int score) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE, true))) {
//            writer.write("Player: " + playerName + ", Score: " + score);
//            writer.newLine();  // Add a new line after each score
//        } catch (IOException e) {
//            System.err.println("Error writing to high score file: " + e.getMessage());
//        }
//        List<Integer> storedScores = readScores();
//        storedScores.sort(Collections.reverseOrder());  // Sort storedScores in descending order
//        System.out.println("High Scores:");
//        for (int i : storedScores) {
//            System.out.println(i);
//        }
//    }
//
//    // Method to read high scores from the file
//    public List<Integer> readScores() {
//        List<Integer> scores = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                scores.add(Integer.parseInt(line));  // Convert each line to an integer
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading high score file: " + e.getMessage());
//        }
//
//        return scores;
//    }
//
//    public String getName(){
//        String playerName = JOptionPane.showInputDialog("Enter your name: ");
//
//        if (playerName != null && !playerName.trim().isEmpty()) {
//            return playerName;
//        } else {
//            System.out.println("No name entered.");
//            return " ";
//        }
//    }
//}
package org.example.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScoreManager {
    private static final String HIGH_SCORE_FILE = "app/src/main/resources/highscores.json"; // Path to your high score file
    private final Gson gson = new Gson();

    // Method to add a score to the high score list
    public void addPrintScore(String playerName, int score) {
        List<ScoreEntry> storedScores = readScores(); // Read existing scores

        // Add the new score entry
        storedScores.add(new ScoreEntry(playerName, score));
        Collections.sort(storedScores); // Sort scores in descending order

        // Write the updated scores back to the JSON file
        writeScores(storedScores);

        // Display the high scores
        System.out.println("High Scores:");
        for (ScoreEntry entry : storedScores) {
            System.out.println(entry);
        }
    }

    // Method to read high scores from the JSON file
    public List<ScoreEntry> readScores() {
        List<ScoreEntry> scores = new ArrayList<>();

        // Read from the JSON file
        try (Reader reader = new FileReader(HIGH_SCORE_FILE)) {
            Type scoreListType = new TypeToken<List<ScoreEntry>>(){}.getType(); // Define the type for deserialization
            scores = gson.fromJson(reader, scoreListType); // Deserialize the JSON into a list of ScoreEntry objects
        } catch (FileNotFoundException e) {
            // If the file doesn't exist, we'll just return an empty list
            System.out.println("High score file not found, starting fresh.");
        } catch (IOException e) {
            System.err.println("Error reading high score file: " + e.getMessage());
        }

        return scores;
    }

    // Method to write high scores to the JSON file
    public void writeScores(List<ScoreEntry> scores) {
        try (Writer writer = new FileWriter(HIGH_SCORE_FILE)) {
            gson.toJson(scores, writer); // Serialize the list of scores to JSON and write to the file
        } catch (IOException e) {
            System.err.println("Error writing to high score file: " + e.getMessage());
        }
    }

    // Method to prompt for a player's name
    public String getName() {
        String playerName = JOptionPane.showInputDialog("Enter your name:");

        if (playerName != null && !playerName.trim().isEmpty()) {
            return playerName;
        } else {
            System.out.println("No name entered.");
            return ""; // Return an empty string if no name is provided
        }
    }

    // Inner class to represent a score entry
    private static class ScoreEntry implements Comparable<ScoreEntry> {
        private final String playerName;
        private final int score;

        public ScoreEntry(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(ScoreEntry other) {
            // Sort by score in descending order
            return Integer.compare(other.score, this.score);
        }

        @Override
        public String toString() {
            return "Player: " + playerName + ", Score: " + score;
        }
    }
}
