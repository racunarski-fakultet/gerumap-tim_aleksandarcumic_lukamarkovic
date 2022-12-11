package main.java.dsw.gerumap.app.gui.swing.state;

import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.event.MouseEvent;

public interface State {
    void mousePressed(MouseEvent mouseEvent, MindMap mindMap);
    void mouseDragged(MouseEvent mouseEvent, MindMap mindMap);
    void mouseReleased(MouseEvent mouseEvent, MindMap mindMap);
}
