package main.java.dsw.gerumap.app.gui.swing.view.visual;

import javafx.scene.Node;
import javafx.scene.shape.Line;
import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;

@Getter
@Setter

public class Link extends Element {

    private Concept from;
    private Concept to;

    public Link(String s, MapNode parent, Color color, int stroke, Concept to, Concept from) {
        super(s, parent, color, stroke);
        this.to = to;
        this.from = from;
    }


    public void setSecondTopic(Concept c2) {
        this.from = c2;
    }
}
