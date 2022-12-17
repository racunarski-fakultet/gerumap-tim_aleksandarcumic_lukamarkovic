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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Link) {
            Link otherObj = (Link) obj;
            return ((this.getFrom().equals(otherObj.getFrom()) && this.getTo().equals(otherObj.getTo())) ||
                    (this.getFrom().equals(otherObj.getTo()) && this.getTo().equals(otherObj.getFrom())));
        }
        return false;
    }

    public void setSecondTopic(Concept c2) {
        this.from = c2;
    }
}
