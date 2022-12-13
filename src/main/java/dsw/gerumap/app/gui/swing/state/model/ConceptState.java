package main.java.dsw.gerumap.app.gui.swing.state.model;

import com.sun.tools.javac.Main;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.event.MouseEvent;

public class ConceptState implements State {

    @Override
    public void misKliknut(int x, int y, MindMap map) {
        Concept concept = new Concept(x, y);
        map.addChild(concept);
    }

    @Override
    public void misPovucen(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void misOtpusten(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscriber(Object obj) {

    }
}
