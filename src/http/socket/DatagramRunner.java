package http.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        var localhost = Inet4Address.getByName("localhost");
        try (var datagramSocket = new DatagramSocket()) {
            var bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,localhost,767);
            datagramSocket.send(packet);
        }

    }
}
