import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class UserHandler implements Runnable {

    private final Socket serverSocket;
    private BufferedReader read;
    private DataOutputStream write;
    private LinkedList<UserHandler> list;

    public UserHandler(Socket serverSocket, LinkedList<UserHandler> list) {
        this.list = list;
        this.serverSocket = serverSocket;
        list.add(this);
    }

    public void broadCast(String message) {
        for (UserHandler user : list) {
            user.dispatchMessage(message);
        }
    }

    private void dispatchMessage(String message) {
        try {
            write.writeBytes(message + "\n");
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            read = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            write = new DataOutputStream(serverSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (serverSocket.isBound()) {
            String lineRead = "";
            try {
                lineRead = read.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(lineRead);
            String serverMsg = "Server says " + lineRead;
            broadCast(serverMsg);
        }
        try {
            read.close();
            write.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
