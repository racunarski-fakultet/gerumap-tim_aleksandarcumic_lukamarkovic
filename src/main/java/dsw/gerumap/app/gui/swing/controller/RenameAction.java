package main.java.dsw.gerumap.app.gui.swing.controller;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.tree.controller.MapTreeCellEditor;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RenameAction extends AbstractGerumapAction{

    public RenameAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, new ImageIcon("src/main/resources/rename.webp"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();

    }
}
