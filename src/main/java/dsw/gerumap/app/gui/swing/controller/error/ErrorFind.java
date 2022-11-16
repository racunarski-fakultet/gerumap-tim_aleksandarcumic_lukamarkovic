package main.java.dsw.gerumap.app.gui.swing.controller.error;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

public class ErrorFind {

    MapTreeItem treeItemSelected;
    ErrorSend errorSend;

    public ErrorFind() {
        treeItemSelected = MainFrame.getInstance().getMapTree().getSelectedNode();
        errorSend = new ErrorSend(treeItemSelected);
    }

}
