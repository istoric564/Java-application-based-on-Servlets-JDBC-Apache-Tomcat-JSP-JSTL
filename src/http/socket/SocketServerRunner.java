package http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(767);
             var socket = serverSocket.accept();
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            var requestClient = inputStream.readUTF();
            while(!"stop".equals(requestClient)){
                System.out.println("Client request: " + requestClient);
                var response = scanner.nextLine();
                outputStream.writeUTF(response);
                requestClient = inputStream.readUTF();
            }
        }
    }
}
