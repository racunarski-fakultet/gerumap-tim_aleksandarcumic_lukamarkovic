package main.java.dsw.gerumap.app.gui.swing.state;

import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface State{
    void misPovucen(int x, int y, MapView map);
    void misOtpusten(int x, int y, MapView map);
    void misKliknut(int x, int y, MapView map);

}
