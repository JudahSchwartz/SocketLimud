import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ZigWigSender zs = null;
        String input;
        while(!((input = JOptionPane.showInputDialog("Are you client or server?")).equalsIgnoreCase( "server") ||  input.equalsIgnoreCase( "client" )))
        {
            System.out.println(input);
            System.out.println("please input server or client");
        }
        switch(input.toLowerCase())
        {

            case "client":
                zs = new Client();
                break;
            case "server":
                zs = new Server();
                break;



        }
        new ZigWigSenderGui(zs);
    }
}
