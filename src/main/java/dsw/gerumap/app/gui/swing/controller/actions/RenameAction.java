package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RenameAction extends AbstractGerumapAction {

    public RenameAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/rename.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

    }
}
