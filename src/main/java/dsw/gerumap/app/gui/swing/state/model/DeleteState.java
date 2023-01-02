package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ConceptPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteState implements State {

    List<ElementPainter> toRemove = new ArrayList<>();

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {

        for(ElementPainter p : map.getMindMap().getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                if(p.getElement() instanceof Concept){
                    Concept c = (Concept) p.getElement();
                    for(LinkPainter painter : c.getLinkList()){
//                        map.getMindMap().removeChild(painter.getElement());
                        toRemove.add(painter);
                    }
                    map.getMindMap().removeChild(p.getElement());
                    toRemove.add(p);
                }else if(p.getElement() instanceof Link){
                    map.getMindMap().removeChild(p.getElement());
                    toRemove.add(p);
                }
            }
        }
        for(ElementPainter n : toRemove){
            map.getMindMap().getPainters().remove(n);
        }
        map.repaint();
    }
}
