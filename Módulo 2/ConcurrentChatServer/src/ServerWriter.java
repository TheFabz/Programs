import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerWriter implements Runnable {

    private Socket socket;
    private DataOutputStream write;
    private Scanner scanner;

    public ServerWriter(Socket socket) {
        this.socket = socket;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            write = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Enter your message: ");
            String sentence = scanner.nextLine();

            try {
                write.writeBytes(sentence + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                write.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
