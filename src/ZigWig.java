import javax.swing.*;
import java.io.Serializable;

public class ZigWig implements Serializable {
    int age;
    String name;
    String gender;

    public ZigWig(String ageFieldText, String nameFieldText, String genderFieldText) {
        try{age = Integer.parseInt(ageFieldText);}
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"put in age incorrectly");

        }
        name = nameFieldText;
        gender = genderFieldText;

    }
}
