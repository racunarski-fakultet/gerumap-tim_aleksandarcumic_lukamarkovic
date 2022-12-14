package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;

@Getter
@Setter

public class LinkPainter extends ElementPainter{

    private Shape shape;
    private Element e;

    public LinkPainter(Element e, Shape s){
        this.e = e;
        this.shape = s;
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getElement().getColor());
        g2d.setStroke(new BasicStroke(e.getStroke()));
        g2d.draw(getShape());
    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }
}
