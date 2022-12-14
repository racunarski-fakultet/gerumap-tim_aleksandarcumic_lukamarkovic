package main.java.dsw.gerumap.app.gui.swing.view.controller;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.ProjectView;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController implements MouseListener, Subscriber {

    private MapView mapView;

    public MouseController(MapView mapView){
        this.mapView = mapView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point pos = e.getPoint();

        MainFrame.getInstance().getProjectView().misKliknut(pos.x, pos.y, mapView);
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    @Override
    public void update(Object obj) {

    }
}
