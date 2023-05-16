import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port

        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            Thread messageReceiverThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageReceiverThread.start();

            String command;
            System.out.println("Enter a command (or 'exit' to quit):");
            while ((command = console.readLine()) != null) {
                out.println(command);
                if (command.equals("exit")) {
                    break;
                }
            }
            messageReceiverThread.join();
            System.out.println("Disconnected");
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            System.err.println("Error communicating with the server: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

