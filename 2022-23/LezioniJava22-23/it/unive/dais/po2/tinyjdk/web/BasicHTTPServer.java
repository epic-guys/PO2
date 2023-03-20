package it.unive.dais.po2.tinyjdk.web;

import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.net.Socket;
import java.net.ServerSocket;

import static it.unive.dais.po2.tinyjdk.web.HTTPConnectionHandler.*;

public class BasicHTTPServer implements HTTPServer {
    /*
     * Server
     * |-> ServerHandler. Thread which waits for connections
     *     |-> ConnectionHandler. Thread that manages connection individually
     * 
     * 
     */
    
    
    
    private int port;
    private ServerSocket socket;
    private Thread serverThread;
    

    public BasicHTTPServer() {
        this(HTTP_PORT);
    }
    
    public BasicHTTPServer(int port) {
        this.port = port;
        try{
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverThread = new Thread(() -> {
            while (true) {
                try {
                    Socket client = socket.accept();
                    //implement the handle method in an asynchronous way
                    new Thread(() -> {
                        try {
                            HTTPConnectionHandler.handle(client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void listen() throws IOException {
        socket = new ServerSocket(port);
        serverThread.start();
    }

    @Override
    public void listen(int port) throws IOException {
        this.port = port;
        listen();
    }

    @Override
    public void stop() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}