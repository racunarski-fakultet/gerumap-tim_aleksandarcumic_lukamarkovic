package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
@Getter
@Setter

public class ConceptPainter extends ElementPainter{

    Concept concept;

    @Override
    public void draw(Graphics g) {
        g.setColor(this.concept.getColor());
        g.drawOval(this.concept.getX(), this.concept.getY(), 200, 100);
        g.drawString(this.concept.getName(), getShape().getBounds().x, getShape().getBounds().y);

    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}
