package main.java.dsw.gerumap.app.gui.swing.tree;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.core.MessageGenerator;
import main.java.dsw.gerumap.app.message.implementation.MessageGeneratorImplementation;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.factory.factoryImplementation.utils.FactoryUtils;
import main.java.dsw.gerumap.app.repository.implementation.Element;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;
import main.java.dsw.gerumap.app.repository.implementation.Project;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;
import java.util.Random;

public class MapTreeImplementation implements MapTree {

    MessageGenerator mg;
    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }



    @Override
    public void addChild(MapTreeItem parent) throws IOException {

        if (!(parent.getMapNode() instanceof MapNodeComposite)) {
            ApplicationFramework.getInstance().getMg().generate(EventType.CANNOTADDCHILD);
            return;
        }
        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void removeChild(MapTreeItem child) throws IOException {
        if(child.getMapNode() instanceof ProjectExplorer) {
            ApplicationFramework.getInstance().getMg().generate(EventType.DELETEPROJEXPL);
            return;
        }
        child.removeAllChildren();
        child.removeFromParent();
        SwingUtilities.updateComponentTreeUI(treeView);

    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    private MapNode createChild(MapNode parent) {
        NodeFactory nf = FactoryUtils.getNodeFactory(parent);
        return nf.getNode(parent);
    }

}
