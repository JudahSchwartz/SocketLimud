import javax.swing.*;
import java.awt.*;

public class ZigWigSenderGui extends JFrame {
    ZigWigSender zigWigSender;
    JTextField otherName;
    JTextField otherAge;
    JTextField otherGender;
    public ZigWigSenderGui()
    {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,600);
        JTextField nameField = new JTextField();

        JTextField ageField = new JTextField();
        JTextField genderField = new JTextField();
        setLayout(new GridLayout(8,5));
        add(ageField);
        add(nameField);

        add(genderField);


        JButton sendButton = new JButton("Send Zigwig");
        sendButton.addActionListener(actionEvent -> sendZigWig(ageField.getText(),nameField.getText(),genderField.getText()));//write me
        add(sendButton);
        add(new JLabel("Zigwig sent to you"));

        otherName = new JTextField();
        otherName.setEditable(false);
        otherGender = new JTextField();
        otherGender.setEditable(false);
        otherAge = new JTextField();
        otherAge.setEditable(false);

        add(otherAge);
        add(otherName);

        add(otherGender);

        setVisible(true);
    }
    private void sendZigWig(String ageFieldText, String nameFieldText, String genderFieldText)
    {
        zigWigSender.sendZigWig(ageFieldText,nameFieldText,genderFieldText);
    }
    public void recieveZigWig(String ageFieldText, String nameFieldText, String genderFieldText)
    {
        otherAge.setText(ageFieldText);
        otherName.setText(nameFieldText);
        otherGender.setText(genderFieldText);
    }

    public void setZigWigSender(ZigWigSender zs) {
        zigWigSender = zs;
    }
}
