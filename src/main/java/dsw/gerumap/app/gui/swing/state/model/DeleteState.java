package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ConceptPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class DeleteState implements State {

    List<ElementPainter> toRemove;
    @Override
    public void misPovucen(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {
        System.out.println("Usao je u DS");
        Concept concept = new Concept("", x, y);


        map.getMindMap().getChildren().remove(concept);





    }
}
