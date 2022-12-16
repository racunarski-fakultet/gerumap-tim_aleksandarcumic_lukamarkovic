package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ConceptPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.Element;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements State {

    private int flag = 0;
    @Override
    public void misPovucen(int x, int y, MapView map) {
        for(ElementPainter painter : map.getPainters()){
            Concept c = (Concept) painter.getElement();

            if(map.getSelectedItems().getElements().contains(c)){
                if(flag == 1){
                    c.setX(x);
                    c.setY(y);
                }
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {

        if(!(map.getSelectedItems().getElements().isEmpty())) {
            for(Element el : map.getSelectedItems().getElements()){
                el.setColor(el.getRealColor());
            }
            map.getSelectedItems().getElements().clear();
        }

        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                map.getSelectedItems().addElement(p.getElement());
                flag = 1;
                p.getElement().setColor(Color.BLUE);
                map.update(map);
            }
        }
    }


}
