import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.IOException;

public class UDPServer {

    private final DatagramSocket udpSocket;
    private int port;
    byte[] buf = new byte[256];


    public UDPServer(int port) throws  IOException {
        this.port = port;
        this.udpSocket = new DatagramSocket(this.port);
    }
    void listen() throws Exception {
        System.out.println("-- Running Server at " + InetAddress.getLocalHost() + "--");
        String msg;

        while (true) {

            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            // blocks until a packet is received
            udpSocket.receive(packet);

            msg = new String(packet.getData());
            String otherMsg = "Altered message: " + msg.toUpperCase();

            byte [] otherArrayDeBaites = otherMsg.getBytes();

            System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + msg);

            DatagramPacket otherPacket = new DatagramPacket(otherArrayDeBaites, otherArrayDeBaites.length, packet.getAddress(),packet.getPort());


            udpSocket.send(otherPacket);
        }
    }

    public static void main(String[] args) throws Exception {
        UDPServer server = new UDPServer(8080);
        server.listen();
    }
}