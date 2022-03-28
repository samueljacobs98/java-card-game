package com.company;

import java.util.Timer;
import java.util.TimerTask;

public class TimeMeasure {
    private int timeLeft;
    private Timer timer;

    public TimeMeasure(int timeLeft, Timer timer) {
        this.timeLeft = timeLeft;
        this.timer = timer;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void stopTimer() {
        this.timer.cancel();
    }

    private int decrementTimeLeft(int timeToDecrement) {
        if (timeToDecrement == 1) this.timer.cancel();
        return timeToDecrement - 1;
    }

    public void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
           public void run() {
               timeLeft = decrementTimeLeft(timeLeft);
               if (timeLeft == 0) {
                   System.out.println("Too slow! Press enter to continue.");
               }
           }
        }, 1000, 1000);
    }
}
