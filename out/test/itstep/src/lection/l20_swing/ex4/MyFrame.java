package lection.l20_swing.ex4;

import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        JPanel jPanel = new JPanel();

        JButton jButton1 = new JButton("Metal");
        jButton1.addActionListener(e->{
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        JButton jButton2 = new JButton("Nimbus");
        jButton2.addActionListener(e->{
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        JButton jButton3 = new JButton("CDE/Motif");
        jButton3.addActionListener(e->{
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        JButton jButton4 = new JButton("Windows");
        jButton4.addActionListener(e->{
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        JButton jButton5 = new JButton("Windows Classic");
        jButton5.addActionListener(e->{
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        JButton jButton6 = new JButton("Darcula");
        jButton6.addActionListener(e->{
            try {
                UIManager.setLookAndFeel(new DarculaLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                unsupportedLookAndFeelException.printStackTrace();
            }
        });

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jPanel.add(jButton6);

        add(jPanel);
    }

    public static void main(String[] args) {

        MyFrame myFrame = new MyFrame();
        myFrame.setSize(300, 300);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
//        for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeelInfos) {
//            System.out.println(lookAndFeelInfo.getName());
//            System.out.println(lookAndFeelInfo.getClassName());
//        }
    }
}
