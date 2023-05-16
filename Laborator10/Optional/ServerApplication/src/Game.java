import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private final Board board;
    private final ArrayList<Player> players;
    private int turn;
    private int winner;
    private boolean started;
    private boolean ended;
    private Timer timer;
    private int remainingTime;

    public Game() {
        board = new Board();
        players = new ArrayList<Player>();
        turn = 0;
        winner = -1;
        started = false;
        ended = false;
        timer = null;
        remainingTime = 15000;
    }

    public synchronized boolean addPlayer(Socket socket) {
        if (players.size() >= 2 || started) {
            return false; // Game is already full or started
        }

        players.add(new Player(socket, board.getNextStoneColor()));

        if (players.size() == 2) {
            start();
        }

        return true;
    }

    public synchronized void makeMove(int row, int col, Socket socket) {
        if (!started || ended || players.size() != 2) {
            Player player = getPlayer(socket);
            player.sendMessage("Jocul nu este in desfasurare");
            return;
        }
        int playerIndex = getPlayerIndex(socket);
        if (playerIndex == -1 || playerIndex != turn) {
            Player player = getPlayer(socket);
            player.sendMessage("Nu este randul tau!");
            return;
        }
        Player player = players.get(playerIndex);
        if (!board.makeMove(row, col, player.getStone())) {
            Player pl = getPlayer(socket);
            pl.sendMessage("Mutare cu succes!");
            return;
        }
        if (board.checkWin(row, col)) {
            winner = playerIndex;
            System.out.println("Game ended!");
            end();
            return;
        }
        turn = (turn + 1) % 2;
    }

    public void start() {
        if (players.size() != 2) {
            return;
        }
        started = true;
        for (Player player : players) {
            player.sendMessage("Game started!");
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                remainingTime -= 1000;
                if (remainingTime <= 0) {
                    if (turn == 0) {
                        winner = 1;
                    } else {
                        winner = 0;
                    }
                    end();
                }
            }
        }, 1000, 1000);
    }

    public void end() {
        ended = true;
        if (timer != null) {
            timer.cancel();
        }

        System.out.println("Winner: " + (winner + 1));

        for (Player player : players) {
            player.sendMessage("Game ended! Winner: " + (winner + 1));
        }
    }

    public synchronized String getBoardString() {
        return board.toString();
    }

    public synchronized Player getPlayer(Socket socket) {
        for (Player player : players) {
            if (player.getSocket() == socket) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private int getPlayerIndex(Socket socket) {
        Player player = getPlayer(socket);
        if (player == null) {
            return -1;
        }
        return players.indexOf(player);
    }
}
