package lection.l20_swing.ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class MyFrame extends JFrame {

    public MyFrame() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("Button");

//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JButton clickedJButton = (JButton) e.getSource();
//                String text = clickedJButton.getText();
//                setTitle(text);
//            }
//        });

        //jButton.addActionListener(EventHandler.create(ActionListener.class, this, "title", "source.text"));

        jButton.addActionListener(e -> setTitle(((JButton) e.getSource()).getText()));

        JTextField jTextField = new JTextField("name", 10);

        JTextArea jTextArea = new JTextArea(5,10);
        JScrollPane jScrollPane = new JScrollPane(jTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea.setLineWrap(true);

        JLabel jLabel = new JLabel("Input your message:");

        jPanel.add(jLabel);
        jPanel.add(jScrollPane);
        jPanel.add(jButton);
        jPanel.add(jTextField);
        add(jPanel);

        revalidate();
    }


    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
