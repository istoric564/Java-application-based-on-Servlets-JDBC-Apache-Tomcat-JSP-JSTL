package http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        try (var datagramServer = new DatagramSocket(767)) {
            byte[] buffer = new byte[128];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramServer.receive(packet);

            System.out.println(new String(buffer));
        }
    }
}
