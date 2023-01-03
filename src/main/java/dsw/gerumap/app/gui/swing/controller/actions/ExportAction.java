package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportAction extends AbstractGerumapAction{

    public ExportAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/export.png"));
        putValue(NAME, "Export");
        putValue(SHORT_DESCRIPTION, "Export");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        File projectFile = null;

        if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            projectFile = jfc.getSelectedFile();
        }

        MapView map = MainFrame.getInstance().getProjectView().getMapView();
        BufferedImage image = new BufferedImage(map.getWidth(), map.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        map.printAll(g);
        g.dispose();
        try {
            ImageIO.write(image, "jpg", new File(projectFile + ".jpg"));
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
