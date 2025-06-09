package examen.TCPfiles;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream in = this.socket.getInputStream(); OutputStream out = this.socket.getOutputStream()) {

            // in to save the file to the server
            String filename = "fisier.txt";
            FileOutputStream fos = new FileOutputStream(filename);

            DataInputStream dis = new DataInputStream(in);
            long fileLength = dis.readLong(); // daca avem un header cu dimensiunea fisierului

            // chunks
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalRead = 0;

            while (totalRead < fileLength && (bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalRead += bytesRead;
            }

            fos.flush();
            System.out.println("File received!");

            // out send message to client
            PrintWriter pw = new PrintWriter(out);
            pw.printf("%s: Thank you for the file!", Thread.currentThread().getName());
            pw.flush();

            fos.close();
            pw.close();
            dis.close();
            this.socket.close();

            System.out.println("Client disconnected!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
