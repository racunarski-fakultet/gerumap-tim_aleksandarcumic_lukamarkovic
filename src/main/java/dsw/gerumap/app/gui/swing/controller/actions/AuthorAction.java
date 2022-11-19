package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AuthorAction extends AbstractGerumapAction{

    public AuthorAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        //putValue(SMALL_ICON, new ImageIcon("src/main/resources/log-out.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected.getMapNode() instanceof Project){
            String newAuthor = JOptionPane.showInputDialog("Enter author name:");
            ((Project)selected.getMapNode()).setAuthor(newAuthor);
        }


    }
}
