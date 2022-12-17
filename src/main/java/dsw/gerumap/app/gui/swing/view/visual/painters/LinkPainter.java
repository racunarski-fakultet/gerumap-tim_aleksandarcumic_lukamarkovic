package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Line2D;

@Getter
@Setter

public class LinkPainter extends ElementPainter{

    private Shape shape;
    private Element element;
    private Point pos1;
    private Point pos2;

    public LinkPainter(Point pos1, Point pos2, Element element) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.element = element;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getElement().getColor());

        shape = new Line2D.Float(pos1.x, pos1.y, pos2.x, pos2.y);

        g2d.setStroke(new BasicStroke(getElement().getStroke()));
        g2d.draw(getShape());

    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }
}
