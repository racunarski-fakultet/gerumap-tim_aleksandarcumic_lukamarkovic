package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;

@Getter
@Setter

public class LinkPainter extends ElementPainter{

    Shape shape;

    public LinkPainter(Element e, Shape s){
        super(e);
        this.shape = s;
    }
    @Override
    public void draw(Graphics g, Element e) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getElement().getColor());
        g2d.setStroke(new BasicStroke(e.getStroke()));
        g2d.draw(getShape());
    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}
