import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())) ) {
            try {
                String command;
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter a command: ");
                while ((command = console.readLine()) != null) {
                    out.println(command);
                    if (command.equals("exit")) {
                        break;
                    }
                }
                socket.close();
                System.out.println("Disconnected");
            } catch (IOException e) {
                System.err.println("Error communicating with server");
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

