package main.java.dsw.gerumap.app.gui.swing.tree.model;

import main.java.dsw.gerumap.app.gui.swing.controller.error.ErrorFind;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;

@Getter
@Setter
public class MapTreeItem extends DefaultMutableTreeNode {

    ErrorFind er;
    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        this.mapNode.setName(name);
    }

}

