package main.java.dsw.gerumap.app.gui.swing.view.visual;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.state.model.ConceptState;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.repository.implementation.Element;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

@Getter
@Setter

public class Concept extends Element {
    private String text;
    private int w = 200, h = 100;
    private int x, y;

    public Concept(int x, int y){

    }
}
