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
    private Concept concept;

    public ConceptPainter(Concept concept, Shape shape){
        this.concept = concept;
        this.shape = shape;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Element e = (Element) concept;
        g2D.setColor(e.getColor());
        g2D.setStroke(new BasicStroke(e.getStroke()));
        g2D.draw(getShape());

        g2D.setPaint(Color.BLACK);
        Concept c = (Concept) e;
        g.drawString(c.getName(), (int)c.getX() + 25, (int)c.getY() + 30);

    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }
}
