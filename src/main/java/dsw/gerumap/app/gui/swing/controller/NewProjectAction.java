package main.java.dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class NewProjectAction extends AbstractGerumapAction {

    public NewProjectAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, new ImageIcon("src/main/resources/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int label = new Random().nextInt(100);
    }
}
