
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

    private final DatagramSocket udpSocket;
    private final InetAddress serverAddress;
    private final int port;
    private final Scanner scanner;
    byte[] byteArray = new byte[256];

    UDPClient(int port) throws IOException {
        this.serverAddress = InetAddress.getByName("localhost");
        this.port = port;
        udpSocket = new DatagramSocket();
        scanner = new Scanner(System.in);
    }

    void start() throws IOException {
        String in;
        while (true) {
            System.out.println("Enter your message: ");
            in = scanner.nextLine();
            DatagramPacket p = new DatagramPacket(in.getBytes(), in.getBytes().length, serverAddress, port);
            this.udpSocket.send(p);

            DatagramPacket otherP = new DatagramPacket( byteArray, byteArray.length);
            this.udpSocket.receive(otherP);

            String otherMSGboa = new String(otherP.getData()).trim();
            System.out.println(otherMSGboa);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        UDPClient client = new UDPClient(8080);
        System.out.println("-- Running UDP Client at " + InetAddress.getLocalHost() + " --");
        client.start();
    }

}