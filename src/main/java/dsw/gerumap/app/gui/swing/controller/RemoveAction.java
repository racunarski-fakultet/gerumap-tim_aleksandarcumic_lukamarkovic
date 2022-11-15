package main.java.dsw.gerumap.app.gui.swing.controller;

import main.java.dsw.gerumap.app.gui.swing.controller.error.Error;
import main.java.dsw.gerumap.app.gui.swing.controller.error.ErrorAction;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.MessageGenerator;
import main.java.dsw.gerumap.app.message.implementation.Message;
import main.java.dsw.gerumap.app.message.implementation.MessageGeneratorImplementation;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractGerumapAction {

    public ErrorAction ea;

    public RemoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, new ImageIcon("src/main/resources/Remove.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getParent() == null) {
            System.out.println("Ovo radi");
            ea = new ErrorAction();
            Message m = new Message("Ne mozete obrisati Project Explorer.", EventType.DELETEPROJEXPL);
        }else{
            MainFrame.getInstance().getMapTree().removeChild(selected);
        }
    }

}
