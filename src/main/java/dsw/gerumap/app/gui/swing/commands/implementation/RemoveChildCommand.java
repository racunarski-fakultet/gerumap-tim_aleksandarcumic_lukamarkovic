package main.java.dsw.gerumap.app.gui.swing.commands.implementation;

import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

public class RemoveChildCommand extends AbstractCommand {

    private MapTreeItem parent;
    private MapTreeItem child;

    public RemoveChildCommand(MapTreeItem parent, MapTreeItem child){
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {
        if(child == null || parent == null) return;

        parent.remove(child);
        ((MapNodeComposite) parent.getMapNode()).removeChild(child.getMapNode());
    }

    @Override
    public void undoCommand() {
        if(child == null || parent == null) return;

        parent.add(child);
        ((MapNodeComposite)(parent.getMapNode())).addChild(child.getMapNode());
    }
}
