package main.java.dsw.gerumap.app.gui.swing.controller;

import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class HelpAction extends AbstractGerumapAction{



    public HelpAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, new ImageIcon("src/main/resources/Help1.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Help");

    }
    public void actionPerformed(ActionEvent arg0){

        Help help = new Help(MainFrame.getInstance(),"Help",false);
        help.setVisible(true);


    }

}
