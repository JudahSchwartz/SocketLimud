
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket connection;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public Server() throws IOException {

        while(true) {
            try (ServerSocket serverSocket = this.serverSocket = new ServerSocket(1234, 10);
                 Socket connection = this.connection =  serverSocket.accept();
                 ObjectOutputStream outputStream = this.outputStream = new ObjectOutputStream(connection.getOutputStream());
                 ObjectInputStream inputStream = this.inputStream = new ObjectInputStream(connection.getInputStream());) {
                outputStream.flush();
            }


        }



    }
}
