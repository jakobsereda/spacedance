package org.example;

public class Timer {
    long time;

    public Timer(){
        this.time = getTime();
    }

    private long getTime(){
        return System.currentTimeMillis() / 1000;
    }

    public void start(){
        this.time += getTime();
    }

    public void stop(){
        this.time = getTime() - this.time;
    }

    public long elapsedTime(){
        return getTime() - this.time;
    }
}
