package lection.l20_swing.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame extends JFrame {
    private JPanel jPanel;
    private JButton jButton;
    public SecondFrame() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        jButton = new JButton("Button");

        jButton.addActionListener(e -> jPanel.setBackground(new Color(25, 238, 46)));

        jPanel = new JPanel();
        jPanel.add(jButton);

        add(jPanel);
        //add(jButton);

        setVisible(true);
    }


}
