package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Element;

import java.awt.*;
@Getter
@Setter

public class ConceptPainter extends ElementPainter{



    public ConceptPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics2D g, Element element) {
        g.setPaint(Color.RED);
        g.setStroke(element.getStroke());
        g.draw(getShape());

        g.fill(getShape());



        g.setColor(element.getColour());
        g.draw(shape);
        g.drawString(element.toString(), getShape().getBounds().x, getShape().getBounds().y);
    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}
