package lection.l20_swing.ex8;

import javax.swing.*;
import java.awt.*;

public class MyFirstForm extends JFrame{
    private JPanel panelMain;
    private JPanel footer;
    private JTextField textField1;
    private JButton button1;

    public MyFirstForm() throws HeadlessException {
        add(panelMain);

        button1.addActionListener(e-> System.out.println("Hello WOrld"));
    }

    public static void main(String[] args) {
        MyFirstForm myFirstForm = new MyFirstForm();
        myFirstForm.setVisible(true);
    }
}
