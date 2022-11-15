package main.java.dsw.gerumap.app.gui.swing.controller.error;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.implementation.Message;

import javax.swing.*;
import java.awt.*;
@Setter
@Getter
public class Error extends JDialog {

    JLabel lblMessage;
    JLabel lblEventType;

    public Error(Frame parent, String title, boolean modal, EventType et, Message m){
        super(parent, title, modal);

        System.out.println("Uslo je u Error ali se nije kreirao prozorcic.");

        lblMessage = new JLabel(m.getContent());
        lblEventType = new JLabel(et.toString());

        JPanel panel = new JPanel();
        setLocationRelativeTo(parent);
        setSize(500, 100);

        panel.setLayout(new GridLayout(1, 2));
        panel.add(lblMessage);
        panel.add(lblEventType);

        System.out.println("Doslo je do ovde.");
        System.out.println(lblEventType.toString());
        System.out.println("a");
        System.out.println(lblMessage.toString());

        this.add(panel);
        panel.setVisible(true);
    }
}
