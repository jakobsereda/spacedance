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
    private static final String HIGH_SCORE_FILE = "app/src/main/resources/highscores.json";
    private final Gson gson = new Gson();

    public void addPrintScore(String playerName, int score) {
        List<ScoreEntry> storedScores = readScores(); 

        storedScores.add(new ScoreEntry(playerName, score));
        Collections.sort(storedScores);

        writeScores(storedScores);

        System.out.println("High Scores:");
        for (ScoreEntry entry : storedScores) {
            System.out.println(entry);
        }
    }

    public List<ScoreEntry> readScores() {
        List<ScoreEntry> scores = new ArrayList<>();

        try (Reader reader = new FileReader(HIGH_SCORE_FILE)) {
            Type scoreListType = new TypeToken<List<ScoreEntry>>(){}.getType();
            scores = gson.fromJson(reader, scoreListType);
        } catch (FileNotFoundException e) {
            System.out.println("High score file not found, starting fresh.");
        } catch (IOException e) {
            System.err.println("Error reading high score file: " + e.getMessage());
        }

        return scores;
    }

    public void writeScores(List<ScoreEntry> scores) {
        try (Writer writer = new FileWriter(HIGH_SCORE_FILE)) {
            gson.toJson(scores, writer); 
        } catch (IOException e) {
            System.err.println("Error writing to high score file: " + e.getMessage());
        }
    }

    public String getName() {
        String playerName = JOptionPane.showInputDialog("Enter your name:");

        if (playerName != null && !playerName.trim().isEmpty()) {
            return playerName;
        } else {
            System.out.println("No name entered.");
            return "";
        }
    }

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
            return Integer.compare(other.score, this.score);
        }

        @Override
        public String toString() {
            return "Player: " + playerName + ", Score: " + score;
        }
    }
}
