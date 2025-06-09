package examen.TCPfiles;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 8001); InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()) {
            // on out
            System.out.println("Sending file to the server...");
            File file = new File("myfile.txt");
            FileInputStream fis = new FileInputStream(file);

            DataOutputStream dos = new DataOutputStream(out);
            dos.writeLong(file.length());

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }

            dos.flush();
            System.out.println("File sent");

            // on in read message from server
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            System.out.println(line);

            fis.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
