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

    public ConceptPainter(Concept concept, Shape shape){
        super(concept);
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g, Element e) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(e.getColor());
        g2D.setStroke(new BasicStroke(e.getStroke()));
        g2D.draw(getShape());

        if(e instanceof Concept){
            g2D.setPaint(Color.BLACK);
            Concept c = (Concept) e;
            g.drawString(c.getName(), (int)c.getX() + 75, (int)c.getY() + 50);
        }
    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}
