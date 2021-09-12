package lection.l20_swing.ex7;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //JPanel jPanel = new JPanel(new FlowLayout());
        //JPanel jPanel = new JPanel();
        JPanel jPanel = new JPanel(new GridLayout(2,2));
        jPanel.add(new JButton("button1"));
        jPanel.add(new JButton("button2"));
        jPanel.add(new JButton("button3"));

        add(jPanel);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
