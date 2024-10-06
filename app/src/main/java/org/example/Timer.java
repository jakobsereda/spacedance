package org.example;

public class Timer {
    long time;

    public Timer(){
        this.time = 0;
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

}
