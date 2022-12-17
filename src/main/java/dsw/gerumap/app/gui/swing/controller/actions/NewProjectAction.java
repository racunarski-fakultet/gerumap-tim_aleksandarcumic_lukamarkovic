package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import com.sun.tools.javac.Main;
import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class NewProjectAction extends AbstractGerumapAction {

    public NewProjectAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if(selected == null) {
            ApplicationFramework.getInstance().getMg().generate(EventType.NODENOTSELECTED);
            return;
        }

        if(selected.getMapNode() instanceof MindMap){
            ApplicationFramework.getInstance().getMg().generate(EventType.CANNOTADDELEMENT);
            return;
        }

        if(selected.getMapNode() instanceof Project){
            MainFrame.getInstance().getMapTree().addChild(selected);
            if(!(((Project) selected.getMapNode()).getAuthor() == null)) {
                MainFrame.getInstance().getProjectView().refreshWorkspace(selected.getMapNode());
            }
            return;
        }

        MainFrame.getInstance().getMapTree().addChild(selected);
    }
}
