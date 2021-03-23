import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TCP_WebServer{

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader read;
    private PrintWriter write;


    public TCP_WebServer() throws IOException, InterruptedException {
        serverSocket = new ServerSocket(8083);
        start();
    }

    public void close() throws IOException {
        write.close();
        read.close();
    }

    public void start() throws IOException, InterruptedException {
        while(true){
            TimeUnit.SECONDS.sleep(1);
            ClientHandler clientHandler = new ClientHandler(serverSocket.accept());
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}



