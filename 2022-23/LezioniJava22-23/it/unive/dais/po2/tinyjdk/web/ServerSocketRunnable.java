package it.unive.dais.po2.tinyjdk.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerSocketRunnable implements Runnable {

    private ServerSocket serverSocket;
    private boolean active;
    private Consumer<Socket> connectionHandler;

    public ServerSocketRunnable(ServerSocket socket, Consumer<Socket> connectionHandler) {
        this.serverSocket = socket;
        this.connectionHandler = connectionHandler;
        active = true;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void run() {
        try {
            while (active) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> connectionHandler.accept(clientSocket));
            }
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        active = false;
    }

}
