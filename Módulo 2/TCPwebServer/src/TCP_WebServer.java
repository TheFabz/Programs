import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_WebServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader read;
    private PrintWriter write;


    public TCP_WebServer() throws IOException {
        start();
        close();
    }

    public void close() throws IOException {
        write.close();
        read.close();
    }

    public void start() throws IOException {

        serverSocket = new ServerSocket(8083);
        clientSocket = serverSocket.accept();
        read = new BufferedReader(new InputStreamReader(( clientSocket.getInputStream())));
        write = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String data = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Page Title</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"\">\n" +
                "<style>\n" +
                "</style>\n" +
                "<script src=\"\"></script>\n" +
                "<body>\n" +
                "\n" +
                "<img src=\"https://cdn.britannica.com/73/191073-050-BCEB0132/reaper-death.jpg\" alt=\"Flowers in Chania\">\n\n" +
                "\n" +
                "<div class=\"\">\n" +
                "    <h1>This is a Heading</h1>\n" +
                "    <p>This is a paragraph.</p>\n" +
                "    <p>This is another paragraph.</p>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        while(true){

            String line = read.readLine();
            System.out.println(line);

            write.write("HTTP/1.0 200 OK \n");
            write.write("Content-Type: text/html; charset=UTF-8\n");
            write.println("Content-Length:" + data.length() +  " \n" );

            write.write(data);
            write.flush();
        }

    }

}
