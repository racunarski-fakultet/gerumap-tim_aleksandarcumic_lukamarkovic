package main.java.dsw.gerumap.app.gui.swing.controller.error;

import main.java.dsw.gerumap.app.message.implementation.Message;

import javax.swing.*;
import java.awt.*;

public class ErrorShow extends JDialog {

    JLabel lblMessage;
    JLabel lblError;

    public ErrorShow(Frame parent, String title, boolean modal, Message m){
        super(parent, title, modal);

        lblMessage = new JLabel(m.getContent());
        lblError = new JLabel("ERROR");

        JFrame frame = new JFrame("Error");
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 100);
        frame.setLayout(new FlowLayout());

        frame.getContentPane().add(lblMessage);
        frame.getContentPane().add(lblError);

        frame.pack();
        frame.setVisible(true);

        System.out.println(lblMessage.toString());
        System.out.println(lblError.toString());
    }

}
