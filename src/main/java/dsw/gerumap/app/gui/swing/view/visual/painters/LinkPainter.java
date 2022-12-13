package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;

public class LinkPainter extends ElementPainter{

    @Override
    public void draw(Graphics g) {
        g.setColor(getElement().getColor());

    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}
