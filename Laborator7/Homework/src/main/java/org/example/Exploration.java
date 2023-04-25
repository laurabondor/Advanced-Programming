package org.example;

import java.util.*;

public class Exploration {
    SharedMemory mem;
    ExplorationMap map;
    List<Robot> robots = new ArrayList<>();

    public Exploration(int n) {
        this.mem = new SharedMemory(n);
        this.map = new ExplorationMap(n);
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public void stop() {
        for (Robot robot : robots) {
            robot.stop();
        }
    }

    public static void main( String[] args ) {
        int timeLimit = 7;

        var explore = new Exploration(4);
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));

        Timekeeper timekeeper = new Timekeeper(explore, timeLimit * 1000);
        Thread timekeeperThread = new Thread(timekeeper);
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();

        //explore.start();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a command: (start/pause)");
            String command = scanner.nextLine();
            if (command.equals("start")) {
                System.out.println("Enter a robot name (or 'all'):");
                String robotName = scanner.nextLine();
                if (robotName.equals("all")) {
                    for (Robot robot : explore.robots) {
                        robot.start();
                    }
                } else {
                    Robot robot = null;
                    for (Robot r : explore.robots) {
                        if (r.getName().equals(robotName)) {
                            robot = r;
                            break;
                        }
                    }
                    if (robot != null) {
                        robot.start();
                    } else {
                        System.out.println("Invalid robot name");
                    }
                }
            } else if (command.equals("pause")) {
                System.out.println("Enter a robot name (or 'all'):");
                String robotName = scanner.nextLine();
                if (robotName.equals("all")) {
                    for (Robot robot : explore.robots) {
                        robot.pause();
                    }
                } else {
                    Robot robot = null;
                    for (Robot r : explore.robots) {
                        if (r.getName().equals(robotName)) {
                            robot = r;
                            break;
                        }
                    }
                    if (robot != null) {
                        robot.pause();
                    } else {
                        System.out.println("Invalid robot name");
                    }
                }
            } else {
                System.out.println("Invalid command");
            }
            scanner.close();
        }
    }
}
