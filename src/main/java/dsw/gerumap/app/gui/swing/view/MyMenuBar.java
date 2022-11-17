package main.java.dsw.gerumap.app.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRemoveAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRenameAction());

        this.add(fileMenu);

        JMenu fileHelp = new JMenu("Help");
        fileHelp.add(MainFrame.getInstance().getActionManager().getHelpAction());

        this.add(fileHelp);
    }
}
