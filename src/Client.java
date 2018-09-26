import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements ZigWigSender {
    Socket connection;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public Client()
    {
        String ip = JOptionPane.showInputDialog("Whats the server's ip?");
        if(ip.equals( "?"))
        {
            ip = null;
        }
        try {
            connection = new Socket(InetAddress.getByName(ip),1234);
            inputStream = new ObjectInputStream(connection.getInputStream());
            outputStream = new ObjectOutputStream(connection.getOutputStream());
            System.out.println("connection started - client");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void sendZigWig(String ageFieldText, String nameFieldText, String genderFieldText) {
        try {
            outputStream.writeObject(new ZigWig(ageFieldText,nameFieldText,genderFieldText));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
