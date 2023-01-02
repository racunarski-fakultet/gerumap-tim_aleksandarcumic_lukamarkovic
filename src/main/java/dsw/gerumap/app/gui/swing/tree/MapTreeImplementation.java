package main.java.dsw.gerumap.app.gui.swing.tree;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.commands.implementation.AddChildCommand;
import main.java.dsw.gerumap.app.gui.swing.commands.implementation.RemoveChildCommand;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeModel;
import main.java.dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.factory.factoryImplementation.utils.FactoryUtils;
import main.java.dsw.gerumap.app.repository.implementation.Project;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;

public class MapTreeImplementation implements MapTree {

    private MapTreeView treeView;
    private MapTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new MapTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }



    @Override
    public void addChild(MapTreeItem parent){

        if (!((parent.getMapNode()) instanceof MapNodeComposite)) {
            return;
        }
        MapNode child = createChild(parent.getMapNode());
        AbstractCommand command = new AddChildCommand(parent, new MapTreeItem(child));
        ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeView getTreeView() {
        return treeView;
    }

    @Override
    public void removeChild(MapTreeItem child){
//        if(child.getMapNode() instanceof ProjectExplorer) {
//            ApplicationFramework.getInstance().getMg().generate(EventType.DELETEPROJEXPL);
//            return;
//        }
        MapTreeItem parent = (MapTreeItem) child.getParent();
        AbstractCommand command = new RemoveChildCommand(parent, child);
//        child.removeAllChildren();
//        child.removeFromParent();
        ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void loadProject(Project node) {
        MapTreeItem loadedProject = new MapTreeItem(node);
        treeModel.getRoot().add(loadedProject);

        MapNodeComposite mapNode = (MapNodeComposite) treeModel.getRoot().getMapNode();
        mapNode.addChild(node);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private MapNode createChild(MapNode parent) {
        NodeFactory nf = FactoryUtils.getNodeFactory(parent);
        return nf.getNode(parent);

    }

}
