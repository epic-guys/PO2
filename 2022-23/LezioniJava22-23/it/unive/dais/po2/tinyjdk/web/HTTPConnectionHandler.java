package it.unive.dais.po2.tinyjdk.web;

import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.function.Consumer;

public class HTTPConnectionHandler implements Consumer<Socket> {

    @Override
    public void accept(Socket connection) {
        try
        {
            PrintStream stream = new PrintStream(connection.getOutputStream());
            stream.println("<body>LMAO</body>");
            stream.close();
            connection.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
    
}
