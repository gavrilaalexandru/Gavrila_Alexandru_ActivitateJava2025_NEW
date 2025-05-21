package csie.ase.ro.seminar12.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {
    public static void main(String[] args) {
        int port = 8000;
        try(DatagramSocket socket = new DatagramSocket(port)) {
            while (true) {
                System.out.println("Server started on port " + port + ".");
                byte[] buffer = new byte[256];
                DatagramPacket packetToBeReceived = new DatagramPacket(buffer, buffer.length);
                socket.receive(packetToBeReceived);
                String messageReceived = new String(packetToBeReceived.getData());
                System.out.println("Received message: " + messageReceived);

                String response  = new String("Data received");
                byte[] bytes = response.getBytes();
                DatagramPacket packetToSent = new DatagramPacket(bytes, bytes.length, packetToBeReceived.getAddress(), packetToBeReceived.getPort());
                socket.send(packetToSent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
