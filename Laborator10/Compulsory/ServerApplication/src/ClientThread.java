import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            try {
                String command;
                while ((command = in.readLine()) != null) {
                    System.out.println("Server received the request: " + command);
                    if (command.equals("stop")) {
                        System.out.println("Server stopped");
                        break;
                    }
                }
                socket.close();
            } catch (IOException e) {
                System.err.println("Error handling client request");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}

