package csie.ase.ro.seminar12.client;

import csie.ase.ro.seminar12.sensor.SensorData;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {
    public static void main(String[] args) {
        SensorData sensor = new SensorData(20, 17.5f);

        try(Socket socket = new Socket("localhost", 8001)) {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(sensor.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
