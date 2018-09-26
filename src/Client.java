import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements ZigWigSender {
    Socket connection;
    public Client()
    {
        String ip = JOptionPane.showInputDialog("Whats the server's ip?");
        if(ip .equals( "?"))
        {
            ip = "localhost";
        }
        try {
            connection = new Socket(InetAddress.getByName(ip),1234);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void sendZigWig(String ageFieldText, String nameFieldText, String genderFieldText) {

    }
}
