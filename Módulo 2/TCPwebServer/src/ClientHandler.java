import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private final Socket clientSocket;
    private BufferedReader read;
    private  PrintWriter write;
    private boolean endedWebsite;
    String line = "";

    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            read = new BufferedReader(new InputStreamReader(( clientSocket.getInputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            write = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

            try {
                line = read.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);

            write.write("HTTP/1.0 200 OK \n Content-Type: text/html; charset=UTF-8\n ");
            write.write("HTTP/1.0 200 OK \n");
            write.write("Content-Type: text/html; charset=UTF-8\n");
            write.println("Content-Length:" + data.length() +  " \n" );

            write.write(data);
            write.flush();

        try {
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        write.close();


    }
}
