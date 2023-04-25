package org.example;

import java.util.*;

public class ExplorationMap {
    private final Cell[][] matrix;
    protected Map<Robot, Integer> tokenCounts = new HashMap<>();
    int n;

    private void addTokenCounts(Robot robot, List<Token> tokens) {
        int count = tokenCounts.getOrDefault(robot, 0);
        count += tokens.size();
        tokenCounts.put(robot, count);
    }

    public ExplorationMap(int n) {
        this.n = n;
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].isVisited()) {
                List<Token> tokens = robot.getCellTokens();
                matrix[row][col].addTokens(tokens);
                matrix[row][col].setVisited(true);
                addTokenCounts(robot, tokens);
                System.out.println(robot.getName() + " visited cell (" + row + "," + col + ") and added " + tokens);
                return true;
            } else {
                return false;
            }
        }
    }

    public int getSize() {
        return n;
    }

    private static class Cell {
        private boolean visited;
        private List<Token> tokens;

        public Cell() {
            visited = false;
            tokens = new ArrayList<Token>();
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void addTokens(List<Token> tokens) {
            this.tokens = tokens;
        }

        @Override
        public String toString() {
            if (visited) {
                return "[" + tokens.size() + "]";
            } else {
                return "[ ]";
            }
        }
    }
}
