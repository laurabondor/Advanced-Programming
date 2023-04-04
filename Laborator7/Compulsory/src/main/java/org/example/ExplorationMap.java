package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    public ExplorationMap(int n) {
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public int getCellCapacity() {
        return matrix.length;
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].isVisited()) {
                List<Token> tokens = robot.extractTokens();
                matrix[row][col].setTokens(tokens);
                matrix[row][col].setVisited(true);
                System.out.println("Robot " + robot.getName() + " visited cell(row,col): (" + row + ", " + col + ")");
                return true;
            } else {
                return false;
            }
        }
    }

    public void storeTokens(int row, int col, List<Token> tokens) {
        synchronized (matrix[row][col]) {
            matrix[row][col].setTokens(tokens);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] cells : matrix) {
            for (Cell cell : cells) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getSize() {
        return matrix.length;
    }

    private static class Cell {
        private boolean visited;
        private List<Token> tokens;

        public Cell() {
            visited = false;
            tokens = new ArrayList<>();
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void setTokens(List<Token> tokens) {
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

