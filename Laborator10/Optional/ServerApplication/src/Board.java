public class Board {
    private static final int SIZE = 15;
    private static final char EMPTY = '-';
    protected static final char BLACK_STONE = 'B';
    protected static final char WHITE_STONE = 'W';
    private char currentStoneColor = WHITE_STONE;
    private final char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = EMPTY;
            }
        }
    }

    public synchronized boolean makeMove(int row, int col, char stone) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        if (grid[row][col] != EMPTY) {
            return false;
        }
        grid[row][col] = stone;
        return true;
    }

    public synchronized boolean checkWin(int row, int col) {
        char stone = grid[row][col];
        if (stone == EMPTY) {
            return false;
        }
        int count = 0;
        // check horizontal
        for (int c = col - 4; c <= col + 4; c++) {
            if (c < 0 || c >= SIZE) {
                continue;
            }
            if (grid[row][c] == stone) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        // check vertical
        count = 0;
        for (int r = row - 4; r <= row + 4; r++) {
            if (r < 0 || r >= SIZE) {
                continue;
            }
            if (grid[r][col] == stone) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        // check diagonal
        count = 0;
        for (int d = -4; d <= 4; d++) {
            int r = row + d;
            int c = col + d;
            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) {
                continue;
            }
            if (grid[r][c] == stone) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        // check anti-diagonal
        count = 0;
        for (int d = -4; d <= 4; d++) {
            int r = row - d;
            int c = col + d;
            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) {
                continue;
            }
            if (grid[r][c] == stone) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public synchronized char getNextStoneColor() {
        char nextStoneColor = currentStoneColor;
        currentStoneColor = (currentStoneColor == WHITE_STONE) ? BLACK_STONE : WHITE_STONE;
        return nextStoneColor;
    }

    @Override
    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char stone = grid[row][col];
                switch (stone) {
                    case BLACK_STONE -> sb.append("B");
                    case WHITE_STONE -> sb.append("W");
                    default -> sb.append("-");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}