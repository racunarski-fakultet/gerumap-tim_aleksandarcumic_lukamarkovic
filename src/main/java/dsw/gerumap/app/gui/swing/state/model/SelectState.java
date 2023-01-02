package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ConceptPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.MultiSelectionPainter;
import main.java.dsw.gerumap.app.repository.implementation.Element;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SelectState implements State {

    private int flag = 0;
    private MultiSelectionPainter msp= new MultiSelectionPainter();
    private List<ElementPainter> painters = new ArrayList<>();

    private int x2,y2;

    @Override
    public void misPovucen(int x, int y, MapView map) {

        if(!(map.getSelectedItems().getElements().isEmpty())) {
            for(Element el : map.getSelectedItems().getElements()){
                el.setColor(el.getRealColor());
            }
            map.getSelectedItems().getElements().clear();
        }
        msp.updatePoints(x2,y2,x,y);
        map.update(msp);

        for(ElementPainter painter : map.getMindMap().getPainters()){
            if(painter instanceof MultiSelectionPainter){
                continue;
            }
            if(msp.getShape() == null){
                map.getMindMap().getPainters().remove(msp);
                return;
            }

            if(msp.getShape().intersects(painter.getShape().getBounds().getX(), painter.getShape().getBounds().getY(), painter.getShape().getBounds().getWidth(), painter.getShape().getBounds().getHeight())){
                map.getSelectedItems().addElement(painter.getElement());
            }

        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

        for(ElementPainter painter: painters){
            map.getMindMap().getPainters().remove(painter);
            msp = new MultiSelectionPainter();

        }


        map.update(this);
    }

    @Override
    public void misKliknut(int x, int y, MapView map) {

        if(!(map.getSelectedItems().getElements().isEmpty())) {
            for(Element el : map.getSelectedItems().getElements()){
                el.setColor(el.getRealColor());
            }
            map.getSelectedItems().getElements().clear();
        }
        painters.clear();

        for(ElementPainter p : map.getMindMap().getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                map.getSelectedItems().addElement(p.getElement());

                p.getElement().setColor(Color.BLUE);
                map.update(map);
            }
            else{
                x2=x;
                y2=y;

                painters.add(msp);
            }

        }
        if(!painters.isEmpty()){
            for(ElementPainter p : painters){
                map.getMindMap().getPainters().add(p);
            }
        }
    }


}
