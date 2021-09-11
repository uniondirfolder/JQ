package lection.l20_swing.ex6;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MyAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(":-)");
    }
}
