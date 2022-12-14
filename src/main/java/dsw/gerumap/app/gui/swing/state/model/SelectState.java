package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ConceptPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State {

    @Override
    public void misPovucen(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {
        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                p.getElement().setColor(Color.BLUE);
//                notify();
            }

        }
    }


}
