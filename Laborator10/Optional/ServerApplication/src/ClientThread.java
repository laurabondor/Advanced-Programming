import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientThread extends Thread {
    private Socket socket = null;
    private static Game game = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String command;
            while ((command = in.readLine()) != null) {
                System.out.println("Server received the command: " + command);
                switch (command) {
                    case "stop":
                        System.out.println("Server stopped");
                        return;
                    case "create game":
                        if (game == null) {
                            game = new Game();
                            System.out.println("Game created");
                        } else {
                            System.out.println("Game already exists");
                        }
                        break;
                    case "join game":
                        if (game != null && game.addPlayer(socket)) {
                            System.out.println("Join successful");
                        } else {
                            System.out.println("Unable to join game");
                        }
                        break;
                    case "submit move":
                        if (game == null) {
                            System.out.println("No game created yet");
                        } else {
                            String moveLine = in.readLine();
                            String[] move = moveLine.split(" ");
                            int row = Integer.parseInt(move[0]);
                            int col = Integer.parseInt(move[1]);
                            Player player = game.getPlayer(socket);
                            if (player != null) {
                                game.makeMove(row, col, player.getSocket());
                            }
                            String boardString = game.getBoardString();
                            for (Player pl : game.getPlayers()) {
                                pl.sendMessage(boardString);
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid command");
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error handling client request");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}



