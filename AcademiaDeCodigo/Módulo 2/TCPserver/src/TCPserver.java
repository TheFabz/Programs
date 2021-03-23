import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    BufferedReader in;
    int port = 8080;


    public TCPserver() throws IOException {
        start();
    }


    public void start() throws IOException {

        serverSocket = new ServerSocket(port);
        System.out.println("Server started: " + serverSocket);

        System.out.println("Waiting for a client connection");
        clientSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while(true){
            System.out.println();

            String line = in.readLine();

            System.out.println(line);

        }

    }
}

class Main {
    public static void main(String[] args) throws IOException {

        TCPserver tcPserver = new TCPserver();

    }
}
