package main.java.dsw.gerumap.app.gui.swing.state;

import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface State extends Publisher {
    void misPovucen(MouseEvent mouseEvent, MindMap mindMap);
    void misOtpusten(MouseEvent mouseEvent, MindMap mindMap);
    void misKliknut(int x, int y, MindMap map);

}
