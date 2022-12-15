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
import java.awt.geom.Ellipse2D;

public class ConceptState implements State {


    @Override
    public void misKliknut(int x, int y, MapView map) {
        Concept concept = new Concept("Concept" + map.getMindMap().getChildren().size(), map.getMindMap(), Color.BLACK, 2, x, y);
        Ellipse2D shape = new Ellipse2D.Float(concept.getX(), concept.getY(), concept.getW(), concept.getH());
        ConceptPainter cP = new ConceptPainter(concept, shape);
        map.getPainters().add(cP);
        map.getMindMap().addChild(concept);
    }

    @Override
    public void misPovucen(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(MouseEvent mouseEvent, MindMap mindMap) {

    }

}
