import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player {
    private final Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private final char stone;
    public Player(Socket socket, char stone) {
        this.socket = socket;
        this.stone = stone;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Socket getSocket() {
        return socket;
    }
    public char getStone() {
        return stone;
    }
    public void sendMessage(String message) {
        output.println(message);
    }
}