package org.example;

import java.util.Map;

public class Timekeeper implements Runnable {
    private final Exploration explore;
    private boolean running;
    private final long timeLimit;
    private final long startTime;

    public Timekeeper(Exploration explore, long timeLimit) {
        this.explore = explore;
        this.running = true;
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
    }

    public void run() {
        while (running) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Elapsed time: " + elapsedTime / 1000 + " seconds");
            if (elapsedTime >= timeLimit) {
                System.out.println("Time limit reached. Stopping exploration.");
                stop();
                explore.stop();

                System.out.println("Each robot with how many tokens has placed in the matrix:");
                for (Map.Entry<Robot, Integer> entry : explore.map.tokenCounts.entrySet()) {
                    Robot robot = entry.getKey();
                    int count = entry.getValue();
                    System.out.println("Robot " + robot.getName() + ": " + count + " tokens");
                }
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}

