package main.java.dsw.gerumap.app.gui.swing.controller;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractGerumapAction {

//    public ErrorAction ea;

    public RemoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, new ImageIcon("src/main/resources/Remove.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
//        if (selected.getParent() == null) {
//            ea = new ErrorAction();
//            Message m = new Message("Ne mozete obrisati Project Explorer.", EventType.DELETEPROJEXPL);
//            Error error = new Error(MainFrame.getInstance(), "Error", false, m.getEt(), m);
//            error.setVisible(true);
//        }else{
            MainFrame.getInstance().getMapTree().removeChild(selected);
//        }
    }

}
