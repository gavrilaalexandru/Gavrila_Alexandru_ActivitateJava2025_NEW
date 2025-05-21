package csie.ase.ro.seminar12.client;

import csie.ase.ro.seminar12.sensor.SensorData;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class ClientUDP {
    public static void main(String[] args) {
        SensorData sensor1 = new SensorData(20, 17.5f);

        try(DatagramSocket socket = new DatagramSocket()) {
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int humidity = random.nextInt(100);
                float temperature = random.nextFloat(45.5f);
                SensorData sensor = new SensorData(humidity, temperature);
                String message = sensor.toString();
                byte[] bytes = message.getBytes();
                DatagramPacket packetToSend = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8000); // sau getByName
                socket.send(packetToSend);

                byte[] buffer = new byte[256];
                DatagramPacket packetResponse = new DatagramPacket(buffer, buffer.length);
                socket.receive(packetResponse);
                String messageReceived = new String(packetResponse.getData());
                System.out.println("Received message: " + messageReceived);
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
