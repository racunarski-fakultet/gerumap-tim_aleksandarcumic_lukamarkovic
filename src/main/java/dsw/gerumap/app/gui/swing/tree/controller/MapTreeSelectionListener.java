package main.java.dsw.gerumap.app.gui.swing.tree.controller;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem)path.getLastPathComponent();
        if(treeItemSelected.getMapNode() instanceof Project){
            MainFrame.getInstance().getProjectView().refreshWorkspace(treeItemSelected.getMapNode());
        }
        System.out.println("Selektovan cvor:"+ treeItemSelected.getMapNode().getName());
        System.out.println("getPath: "+e.getPath());
    }
}

