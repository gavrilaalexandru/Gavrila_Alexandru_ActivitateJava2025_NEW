package examen.TCPobj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    public static void main(String[] args) {
        int port = 8001;
        boolean listening = true;

        ExecutorService executor = Executors.newFixedThreadPool(10);

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (listening) {
                Socket socket = serverSocket.accept();
                executor.submit(new ClientHandler(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            executor.shutdown();
            System.out.println("Server stopped");
        }
    }
}
