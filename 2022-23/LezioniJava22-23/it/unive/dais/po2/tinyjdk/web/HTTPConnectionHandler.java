import java.io.IOException;
import java.net.Socket;

class HTTPConnectionHandler extends Thread {
    Socket connection;
    public HTTPConnectionHandler(Socket connection) {
        this.connection = connection;
        
    }
}