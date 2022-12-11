package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.event.MouseEvent;

public class ConceptState implements State {

    MindMap mindMap;
    public ConceptState(){
//        mindMap = MainFrame.getInstance().getProjectView().getSm().getConceptState().mindMap;
//        Concept concept = new Concept();
        //mindMap.addChild(concept);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent, MindMap mindMap) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent, MindMap mindMap) {

    }
}
