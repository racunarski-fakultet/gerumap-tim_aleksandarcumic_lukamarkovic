package main.java.dsw.gerumap.app.gui.swing.controller.error;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.MessageGenerator;
import main.java.dsw.gerumap.app.message.implementation.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;
@Setter
@Getter
public class Error extends JDialog {

    JLabel lblMessage;

    public Error(Frame parent, String title, boolean modal, EventType et, Message m){
        super(parent, title, modal);

        System.out.println("Uslo je u Error ali se nije kreirao prozorcic.");

        lblMessage = new JLabel(m.getContent());

        JTextArea taMessage = new JTextArea();
        taMessage.setText(m.getContent());

        JPanel panel = new JPanel();
        setSize(300, 200);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(taMessage);

        System.out.println("Doslo je do ovde.");

        this.add(panel);
        panel.setVisible(true);
    }
}
