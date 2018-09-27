
import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ZigWigSender {
    ServerSocket serverSocket;
    Socket connection;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    ZigWigSenderGui zsg;
    boolean server;

    public ZigWigSender(boolean server) throws IOException {
        this.server = server;
    }
    public void start()
    {

        // while(connection == null || connection.isClosed()) {
        System.out.println("Waiting for connection. Window will pop up when connected");

        String ip = null;
        try ( ServerSocket serverSocket = this.serverSocket = server?new ServerSocket(1234, 10):null;
              Socket connection = server? this.connection = serverSocket.accept():new Socket(InetAddress.getByName(ip),1234);
              ObjectOutputStream outputStream = this.outputStream = new ObjectOutputStream(connection.getOutputStream());
              ObjectInputStream inputStream = this.inputStream = new ObjectInputStream(connection.getInputStream())) {

            System.out.println("connection started - " + (server ? "server":"client"));
            outputStream.flush();

            while (true) {
                ZigWig out = (ZigWig) inputStream.readObject();
                if (zsg != null)
                    zsg.recieveZigWig(out.age + "", out.name,out.gender);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // }
    }
    public void sendZigWig(String ageFieldText, String nameFieldText, String genderFieldText) {
        ZigWig z = new ZigWig(ageFieldText,nameFieldText,genderFieldText);
        if(outputStream != null) {
            try {
                outputStream.writeObject(z);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void setZigWigSenderGui(ZigWigSenderGui zigWigSenderGui) {
        this.zsg = zigWigSenderGui;
    }
}
