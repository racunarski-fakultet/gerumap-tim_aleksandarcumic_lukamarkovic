package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
@Getter
@Setter

public class ConceptPainter extends ElementPainter{

    private Shape shape;
    private Element element;

    public ConceptPainter(Element element, Shape shape){
        this.element = element;
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(element.getColor());
        g2D.setStroke(new BasicStroke(element.getStroke()));
        g2D.draw(getShape());

        if(element instanceof Concept) {
            Concept c = (Concept) element;
            g.drawString(c.getName(), (int) c.getX() + 25, (int) c.getY() + 30);
        }
    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }
}
