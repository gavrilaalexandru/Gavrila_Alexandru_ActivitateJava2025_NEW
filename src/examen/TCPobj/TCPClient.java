package examen.TCPobj;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 8001); InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            ObjectOutputStream oos = new ObjectOutputStream(out);

            // sau aici scrii nr de carti trimise
            Book book = new Book("Carte1", 100);
            Book book2 = new Book("Carte2", 100);


            System.out.println("Sending book to server");

            oos.writeObject(book);
            oos.writeObject(book2);
            oos.flush();

            String line = br.readLine();
            System.out.println(line);

            oos.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
