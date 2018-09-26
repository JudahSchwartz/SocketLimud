
import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ZigWigSender {
    ServerSocket serverSocket;
    Socket connection;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public Server() throws IOException {


        while(true) {
            JOptionPane.showMessageDialog(null,"Waiting for connection. Window will pop up when connected");
            try (ServerSocket serverSocket = this.serverSocket = new ServerSocket(1234, 10);
                 Socket connection = this.connection =  serverSocket.accept();
                 ObjectOutputStream outputStream = this.outputStream = new ObjectOutputStream(connection.getOutputStream());
                 ObjectInputStream inputStream = this.inputStream = new ObjectInputStream(connection.getInputStream());) {
                outputStream.flush();
            }
        }
    }

    @Override
    public void sendZigWig(String ageFieldText, String nameFieldText, String genderFieldText) {
        ZigWig z = new ZigWig(ageFieldText,nameFieldText,genderFieldText);
        try {
            outputStream.writeObject(z);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
