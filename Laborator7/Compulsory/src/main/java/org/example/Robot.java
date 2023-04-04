package org.example;

import java.util.ArrayList;
import java.util.List;

public class Robot implements Runnable{
    private String name;
    private boolean running;
    Exploration explore;
    private List<Token> tokens = new ArrayList<>();
    public Robot(String name) {
        this.name = name;
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            int row = (int) (Math.random() * explore.getMap().getSize());
            int col = (int) (Math.random() * explore.getMap().getSize());
            explore.getMap().visit(row, col, this);
        }
    }

    public List<Token> extractTokens() {
        List<Token> extractedTokens = new ArrayList<>(tokens);
        tokens.clear();
        return extractedTokens;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Robot " + name;
    }
}
