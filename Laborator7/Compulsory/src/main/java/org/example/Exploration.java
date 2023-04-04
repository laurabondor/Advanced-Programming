package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(10);
    private final ExplorationMap map = new ExplorationMap(5);
    private final List<Robot> robots = new ArrayList<>();
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start() {
        for (Robot robot : robots) {
            Thread t = new Thread(() -> {
                while (true) {
                    int row = getRandomRow();
                    int col = getRandomCol();
                    if (map.visit(row, col, robot)) {
                        List<Token> tokens = mem.extractTokens(map.getCellCapacity());
                        map.storeTokens(row, col, tokens);
                    }
                }
            });
            t.start();
        }
    }

    private int getRandomRow() {
        return ThreadLocalRandom.current().nextInt(map.getSize());
    }

    private int getRandomCol() {
        return ThreadLocalRandom.current().nextInt(map.getSize());
    }

    public static void main(String[] args) {
        var explore  = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }
}
