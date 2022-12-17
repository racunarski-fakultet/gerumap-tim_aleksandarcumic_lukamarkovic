package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@Setter

public class ConceptPainter extends ElementPainter{

    private Shape shape;
    private Element element;
    private Concept c;

    public ConceptPainter(Element element){
        this.element = element;
        c = (Concept) element;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(element.getColor());
        g2D.setStroke(new BasicStroke(element.getStroke()));
        shape = new Ellipse2D.Float(c.getX()-50, c.getY()-25, c.getW(), c.getH());
        g2D.draw(getShape());

        if(element instanceof Concept) {
            Concept c = (Concept) element;
            g.drawString(c.getName(), (int) c.getX()-20 , (int) c.getY());
        }
    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }
}
