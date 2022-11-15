package main.java.dsw.gerumap.app.gui.swing.controller.error;

import main.java.dsw.gerumap.app.gui.swing.controller.RemoveAction;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.implementation.Message;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorAction implements ActionListener {

    Error er;
    JLabel lblMessage;
    Message m;
    EventType et;
    MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

    public ErrorAction(){
        System.out.println("Ovo je prvo uradilo.");
        et = EventType.DELETEPROJEXPL;
        m = new Message("Ne mozete obrisati Project Explorer", et);
//        Error er = new Error(MainFrame.getInstance(), selected.getParent().toString(), false, et, m);
        er = new Error(new Frame(), "There has been an error.", false, et, m);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed je pokrenut u ErrorActionu");
    }
}
