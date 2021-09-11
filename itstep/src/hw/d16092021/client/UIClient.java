package hw.d16092021.client;



import com.bulenkov.darcula.DarculaLaf;
import hw.d16092021.general.ConnectException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class UIClient extends JFrame implements ActionListener{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new UIClient());
    }
    //-----------------------------------------------------
    private final String IP_ADDRESS = "localhost";
    private final int PORT = 45000;
    private String nickName = "anonymous";
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final String IMG ="C:\\REPO\\JQ\\itstep\\src\\hw\\d16092021\\img\\img_1.png";
    private Client client;

    private final JTextArea monitor = new JTextArea();
    private final JTextField fieldNickname = new JTextField(nickName);
    private final JTextField fieldInput = new JTextField();

    //-----------------------------------------------------

    public UIClient(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        monitor.setEditable(false);
        monitor.setLineWrap(true);
        add(monitor, BorderLayout.CENTER);
        fieldInput.addActionListener(this);
        add(fieldInput,BorderLayout.SOUTH);
        add(fieldNickname,BorderLayout.NORTH);
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            printMsg("UI exception: " + e);
        }
        SwingUtilities.updateComponentTreeUI(this);
        Image icon = Toolkit.getDefaultToolkit().getImage(IMG);

        setIconImage(icon);
        setTitle("Twit chat...");
        SwingUtilities.updateComponentTreeUI(this);

        //-----------------------------------------------------
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                try {
                    client.sendMessage("exit");
                    Thread.sleep(1000);
                } catch (InterruptedException | ConnectException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        setVisible(true);
        try {
            client = new Client(this);
            client.start();
        } catch (IOException e) {
            printMsg("Connection exception: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if(msg.equals(""))return;
        fieldInput.setText(null);
        try {
            client.sendMessage(msg);
        } catch (ConnectException ex) {
            ex.printStackTrace();
        }
    }

    public void printMsg(String msg) {
        SwingUtilities.invokeLater(() -> {
            monitor.append(msg + "\n");
            monitor.setCaretPosition(monitor.getDocument().getLength());
        });
    }

    public String getIP_ADDRESS() {
        return IP_ADDRESS;
    }

    public int getPORT() {
        return PORT;
    }

    public String getNickName() {
        this.nickName = fieldNickname.getText();
        return nickName;
    }


}


// https://www.javatpoint.com/how-to-change-titlebar-icon-in-java-awt-swing