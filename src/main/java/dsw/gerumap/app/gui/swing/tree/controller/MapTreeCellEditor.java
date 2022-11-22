package main.java.dsw.gerumap.app.gui.swing.tree.controller;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.core.MessageGenerator;
import main.java.dsw.gerumap.app.message.implementation.MessageGeneratorImplementation;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.EventObject;

@Getter
@Setter
public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    MessageGenerator mg;
    private Object clickedOn =null;
    private JTextField edit=null;

    public JTextField getEdit() {
        return edit;
    }

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);

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

        if(edit.getText().equals("")){
            ApplicationFramework.getInstance().getMg().generate(EventType.NAMECANNOTBEEMPTY);
        }
        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());

    }



}
