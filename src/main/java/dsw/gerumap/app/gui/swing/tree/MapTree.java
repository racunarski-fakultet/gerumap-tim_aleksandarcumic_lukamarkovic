package main.java.dsw.gerumap.app.gui.swing.tree;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();

}

