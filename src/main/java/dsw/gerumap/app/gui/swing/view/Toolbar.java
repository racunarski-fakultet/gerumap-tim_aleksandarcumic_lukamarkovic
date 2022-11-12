package main.java.dsw.gerumap.app.gui.swing.view;

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
    }
}
