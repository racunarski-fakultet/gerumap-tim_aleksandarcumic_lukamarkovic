package main.java.dsw.gerumap.app.gui.swing.tree.controller;

import main.java.dsw.gerumap.app.gui.swing.controller.error.ErrorFind;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    ErrorFind er;
    private Object clickedOn =null;
    private JTextField edit=null;

    public JTextField getEdit() {
        return edit;
    }

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        if(edit.toString().equals("")){
            er = new ErrorFind();
        }
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }



    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof MapTreeItem))
            return;

        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());

    }



}
