package main.java.dsw.gerumap.app.gui.swing;

import main.java.dsw.gerumap.app.core.Gui;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.implementation.Message;

import javax.swing.*;

public class SwingGui implements Gui {

    private MainFrame instance;

    public SwingGui(){

    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }

    @Override
    public void update(Object obj) {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), ((Message)obj), "Dialog", JOptionPane.ERROR_MESSAGE);
    }
}
