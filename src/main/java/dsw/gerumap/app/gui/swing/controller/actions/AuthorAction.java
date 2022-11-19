package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AuthorAction extends AbstractGerumapAction{

    public AuthorAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,loadIcon("/images/Author.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null) {
            try {
                ApplicationFramework.getInstance().getMg().generate(EventType.NODENOTSELECTED);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return;
        }

        if(selected.getMapNode() instanceof Project){
            String newAuthor = JOptionPane.showInputDialog("Enter author name:");
            ((Project)selected.getMapNode()).setAuthor(newAuthor);
        }


    }
}
