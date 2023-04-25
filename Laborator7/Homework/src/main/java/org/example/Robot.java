package org.example;

import java.util.List;
import java.util.Random;

public class Robot implements Runnable {
    String name;
    boolean running;
    Exploration explore;
    Random rand;
    private boolean paused;
    SharedMemory tokenList;
    List<Token> extractedTokens;

    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        this.running = true;
        this.paused = false;
        this.rand = new Random();
        this.tokenList = explore.getMem();
    }

    public void start() {
        running = true;
        paused = false;
        new Thread(this).start();
    }

    public void pause() {
        paused = true;
    }

    public void unpause() {
        paused = false;
    }

    public void stop() {
        this.running = false;
    }


    public void run() {
        int row = 0;
        int col = 0;
        while (running) {
            if (!paused) {
                int numTokensToExtract = rand.nextInt(3) + 1;
                extractedTokens = tokenList.extractTokens(numTokensToExtract);
                explore.map.visit(row, col, this);
                if (row == explore.map.getSize() - 1 && col == explore.map.getSize() - 1) {
                    pause();
                }
                if (col == explore.map.getSize() - 1) {
                    row++;
                    col = 0;
                }else {
                    col++;
                }
                try {
                    Thread.sleep(rand.nextInt(400) + 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Token> getCellTokens(){
        return this.extractedTokens;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}