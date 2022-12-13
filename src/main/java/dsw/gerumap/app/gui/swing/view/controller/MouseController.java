package main.java.dsw.gerumap.app.gui.swing.view.controller;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.ProjectView;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController implements MouseListener {

    private MapView mapView;

    public MouseController(MapView mapView){
        this.mapView = mapView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        MainFrame.getInstance().getProjectView().misKliknut(e.getLocationOnScreen().x, e.getLocationOnScreen().y, mapView.getMindMap());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
