package main.java.dsw.gerumap.app.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);

        /*
        JButton btnExit = new JButton();
        btnExit.setToolTipText("Exit");

        btnExit.setAction(MainFrame.getInstance().getActionManager().getExitAction());
        btnExit.setIcon(new ImageIcon("src\\main\\resources\\images\\log-out.png"));
        add(btnExit);
        */

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getHelpAction());
        add(MainFrame.getInstance().getActionManager().getRemoveAction());
       // add(MainFrame.getInstance().getActionManager().getRenameAction());
        add(MainFrame.getInstance().getActionManager().getAuthorAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getExportAction());

    }
}
