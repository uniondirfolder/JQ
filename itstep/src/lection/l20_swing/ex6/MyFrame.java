package lection.l20_swing.ex6;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() throws HeadlessException {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("smile");

        jButton.addActionListener(new MyAction());

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl shift S");
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        final String key = "show smile";
        inputMap.put(keyStroke, key);

        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put(key, new MyAction());

        jPanel.add(jButton);
        add(jPanel);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
