package lection.l20_swing.ex1;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //JFrame jFrame = new JFrame() {};
        FirstFrame firstFrame = new FirstFrame();
        firstFrame.setVisible(true);
        firstFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //firstFrame.setSize(25,250);
        //firstFrame.setBounds(500,250,300,300);

//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        firstFrame.setBounds(dimension.width/2-125,0,250,250);

        firstFrame.setSize(300,300);
        firstFrame.setLocationRelativeTo(null);

        firstFrame.setTitle("Calculator");
    }
}
