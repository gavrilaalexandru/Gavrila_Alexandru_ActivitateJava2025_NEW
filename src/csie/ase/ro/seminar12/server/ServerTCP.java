package csie.ase.ro.seminar12.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        int port = 8001;

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server connected on port " + port + ".");

            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            String receiveMessage = dataInputStream.readUTF();
            System.out.println("Message received: " + receiveMessage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
