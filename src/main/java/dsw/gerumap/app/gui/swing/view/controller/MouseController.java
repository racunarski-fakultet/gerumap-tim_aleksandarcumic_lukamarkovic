package main.java.dsw.gerumap.app.gui.swing.view.controller;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController extends MouseAdapter implements Subscriber {

    private MapView mapView;

    public MouseController(MapView mapView){
        this.mapView = mapView;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point pos = e.getPoint();
        MainFrame.getInstance().getProjectView().misKliknut(pos.x, pos.y, mapView);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point pos = e.getPoint();
        MainFrame.getInstance().getProjectView().misOtpusten(pos.x, pos.y, mapView);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point pos = e.getPoint();
        MainFrame.getInstance().getProjectView().misPovucen(pos.x, pos.y, mapView);
    }

    @Override
    public void update(Object obj) {

    }
}
