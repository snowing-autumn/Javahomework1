package homework2;

import javax.swing.*;
import java.awt.*;

public class myImagine {

    public static void displayImage(Image img){
        JFrame frame=new JFrame("图片显示");
        ImageIcon imgicon=new ImageIcon(img);
        frame.setSize(imgicon.getIconWidth(),imgicon.getIconHeight());
        JLabel label = new JLabel();
        label.setIcon(imgicon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
