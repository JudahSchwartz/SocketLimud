import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        String input;
        while (!((input = JOptionPane.showInputDialog("Are you client or server?")).equalsIgnoreCase("server") || input.equalsIgnoreCase("client"))) {
            System.out.println(input);
            System.out.println("please input server or client");
        }
        var zsg = new ZigWigSenderGui();

        var sender = new ZigWigSender( input.equalsIgnoreCase("server"));

        zsg.setZigWigSender(sender);
        sender.setZigWigSenderGui(zsg);
        sender.start();






    }

}

