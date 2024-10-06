package org.example;

public class Timer {
    private long startTime;
    private long duration;

    public Timer(int duration) {
        this.startTime = 0;
        this.duration = duration;
    }

    // Sets a new countdown duration (in seconds)
    public void setDuration(long seconds) {
        this.duration = seconds;
    }

    // Start the timer
    public void start() {
        this.startTime = System.currentTimeMillis() / 1000;
    }

    // Stop the timer and return elapsed time
    public long stop() {
        long currentTime = System.currentTimeMillis() / 1000;
        return currentTime - startTime;
    }

    // Get the remaining time on the countdown
    public long getRemainingTime() {
        long currentTime = System.currentTimeMillis() / 1000;
        long elapsed = currentTime - startTime;
        return Math.max(0, duration - elapsed);
    }

    // Check if the timer has finished counting down
    public boolean isFinished() {
        return getRemainingTime() <= 0;
    }
}
