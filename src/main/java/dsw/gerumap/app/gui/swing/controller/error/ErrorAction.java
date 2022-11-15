package main.java.dsw.gerumap.app.gui.swing.controller.error;

import main.java.dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;
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

public class ErrorAction extends AbstractGerumapAction {

    JLabel lblMessage;
    Message m;
    EventType et;
    Error er;

    public ErrorAction(){
        System.out.println("Ovo je prvo uradilo.");
        this.et = EventType.DELETEPROJEXPL;
        this.m = new Message("Ne mozete obrisati Project Explorer", this.et);
//        Error er = new Error(MainFrame.getInstance(), selected.getParent().toString(), false, et, m);
        this.er = new Error(MainFrame.getInstance(), "There has been an error.", false, this.et, this.m);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("actionPerformed je pokrenut u ErrorActionu");
        this.er.setVisible(true);
    }
}
