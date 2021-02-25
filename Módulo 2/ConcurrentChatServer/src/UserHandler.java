import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class UserHandler implements Runnable {

    private final Socket serverSocket;
    private DataOutputStream write;
    private final LinkedList<UserHandler> list;
    private String lineRead = "";
    private final Scanner userName;
    private String name;
    private boolean isUserNameSet;
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String RESET = "\033[0m";  // Text Reset
    private String currentColor = BLUE;


    public UserHandler(Socket serverSocket, LinkedList<UserHandler> list) throws IOException {
        this.list = list;
        this.serverSocket = serverSocket;
        userName = new Scanner(serverSocket.getInputStream());
        list.add(this);
    }

    private String getName(){
        return name;
    }

    public void broadCast(String message) {
        for (UserHandler user : list) {
            if(user != this) {
                user.dispatchMessage(message);
            }
        }
    }

    private void dispatchMessage(String message) {
        try {
            write.writeBytes(message + "\n");
            write.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void setUserName() throws IOException {
        if (!isUserNameSet) {
            isUserNameSet = true;
            name = userName.nextLine();
            Thread.currentThread().setName(name);
            write.writeBytes("welcome " + Thread.currentThread().getName() + "\n");
        }
    }

    public void printOnlineUsers() throws IOException {
        for(UserHandler user : list){
            write.writeBytes(user.getName() + "\n");
        }
    }

    public void setColor(String color){
        switch(color){
            case "BLACK" -> currentColor = BLACK;
            case "RED" -> currentColor = RED;
            case "GREEN" -> currentColor = GREEN;
            case "YELLOW" -> currentColor = YELLOW;
            case "BLUE" -> currentColor = BLUE;
            case "PURPLE" -> currentColor = PURPLE;
            case "CYAN" -> currentColor = CYAN;
            case "WHITE" -> currentColor = WHITE;
        }

    }

    private void chatCommands() throws IOException {
        if (lineRead.contains("/help")) {
            write.writeBytes("/help for help --- /setColor for colors --- /participants to see online users --- /pm for private message --- /quit to quit  \n");
        } else if (lineRead.contains("/setColor")) {
            write.writeBytes("Please select the color you would like to use:\n");
            write.writeBytes("BLACK -- RED -- GREEN -- YELLOW -- BLUE -- PURPLE -- CYAN --WHITE\n");
        } else if (lineRead.contains("BLACK")) {
            setColor("BLACK");
        } else if (lineRead.contains("RED")) {
            setColor("RED");
        } else if (lineRead.contains("GREEN")) {
            setColor("GREEN");
        } else if (lineRead.contains("YELLOW")) {
            setColor("YELLOW");
        } else if (lineRead.contains("BLUE")) {
            setColor("BLUE");
        } else if (lineRead.contains("PURPLE")) {
            setColor("PURPLE");
        } else if (lineRead.contains("CYAN")) {
            setColor("CYAN");
        } else if (lineRead.contains("WHITE")) {
            setColor("WHITE");
        }else if(lineRead.contains("/participants")){
            printOnlineUsers();
        } else if(lineRead.contains(name)){
            privateMessage(name);
        }
    }

    private void privateMessage(String userName){
        for(UserHandler user : list){
            if(user.getName().equals(userName)){
                user.dispatchMessage("test");
            }
        }
    }

    @Override
    public void run() {

        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            write = new DataOutputStream(serverSocket.getOutputStream());

            write.writeBytes(GREEN + "Connection established \n" + RESET);
            write.writeBytes(GREEN + "type /help to see available commands \n" + RESET);
            write.writeBytes("Please setup your username \n");
            setUserName();
            write.writeBytes("Please enter your message \n");

            while (serverSocket.isBound()) {
                lineRead = read.readLine();
                chatCommands();
                System.out.println(lineRead);
                String serverMsg = (currentColor + Thread.currentThread().getName() + " says: " + lineRead);
                broadCast(serverMsg);
            }
            read.close();
            write.close();
            serverSocket.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

}
