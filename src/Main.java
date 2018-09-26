import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        String input;
        while (!((input = JOptionPane.showInputDialog("Are you client or server?")).equalsIgnoreCase("server") || input.equalsIgnoreCase("client"))) {
            System.out.println(input);
            System.out.println("please input server or client");
        }
        ZigWigSender server = new ZigWigSender( input.equalsIgnoreCase("server"));

        ZigWigSenderGui zsg = new ZigWigSenderGui(server);
        server.setZigWigSenderGui(zsg);



    }

}

