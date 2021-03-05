package org.academiadecodigo.forcau.server;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    //Fields
    private LinkedList<UserHandler> list;
    private ServerSocket serverSocket;
    private final ExecutorService fixedPool;
    private int portNumber;
    private Game game;

    //Constructor
    public Server(LinkedList<UserHandler> list, Game game) throws IOException {
        this.list = list;
        this.game = game;
        serverSocket = new ServerSocket(setPortNumber());
        fixedPool = Executors.newFixedThreadPool(10);
        start();
    }

    /**
     * Method start
     */
    public void start() {
        while (serverSocket.isBound()) {
            try {
                System.out.println("Waiting for a Client connection on PortNumber " + portNumber);
                UserHandler userHandler = new UserHandler(serverSocket.accept(), list,game);
                fixedPool.submit(userHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cleanUp(serverSocket);
    }

    public static void main(String[] args) {
        try {
            LinkedList<UserHandler> list = new LinkedList<>();
            Game game = new Game();
            Server server = new Server(list,game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanUp(Closeable closeable){
        try{
            if(closeable != null){
                closeable.close();
            }
        } catch (IOException closeERROR){}
    }

    public int setPortNumber(){
        Scanner sysIn = new Scanner(System.in);
        portNumber = 0;
        do{
            System.out.print("Welcome.\nPlease enter Port Number: ");
            portNumber = sysIn.nextInt();
            if (portNumber == 1){
                portNumber = 16969;
            }
        } while (portNumber == 0);
        return portNumber;
    }

}
