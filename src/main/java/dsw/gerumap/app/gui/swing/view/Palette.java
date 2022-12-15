package main.java.dsw.gerumap.app.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class Palette extends JToolBar {

    public Palette(){
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getConceptAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getLinkAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSelectAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getMoveAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getZoomInAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getZoomOutAction());
        add(Box.createGlue());

        //dodati edit

    }
}
