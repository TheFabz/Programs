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
                "<img src=\"img_la.jpg\" alt=\"LA\" style=\"width:100%\">\n" +
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

            write.write("HTTP/1.0 200 OK \n" +
                    "Content-Type: text/html; charset=UTF-8\n" +
                    "Content-Length:" + data.length() +  " \n" +
                    "\n");

            write.write(data);
            write.flush();
        }

    }

}
