package examen.TCPobj;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()) {
            ObjectInputStream ois = new ObjectInputStream(in);
            PrintWriter pw = new PrintWriter(out);

            try {
                while (true) {
                    Book book = (Book) ois.readObject();
                    System.out.println("Received " + book);
                }
            } catch (EOFException e) {
                e.printStackTrace();
            }

            pw.printf("Thank you for the books");
            pw.flush();

            ois.close();
            pw.close();
            this.socket.close();

            System.out.println("Client disconnected");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
