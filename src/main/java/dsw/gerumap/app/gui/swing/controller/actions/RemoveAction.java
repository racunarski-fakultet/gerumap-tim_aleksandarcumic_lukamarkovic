package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.core.MessageGenerator;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractGerumapAction {

    public RemoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, new ImageIcon("src/main/resources/Remove.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null) {
            ApplicationFramework.getInstance().getMg().generate(EventType.NODENOTSELECTED);
            return;
        }

        if(selected.getMapNode() instanceof ProjectExplorer){
            ApplicationFramework.getInstance().getMg().generate(EventType.DELETEPROJEXPL);
        }

        MainFrame.getInstance().getMapTree().removeChild(selected);

    }

}
