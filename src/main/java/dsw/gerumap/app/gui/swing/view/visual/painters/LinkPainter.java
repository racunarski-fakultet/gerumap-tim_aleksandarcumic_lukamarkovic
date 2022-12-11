package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import main.java.dsw.gerumap.app.gui.swing.view.visual.Element;

import java.awt.*;

public class LinkPainter extends ElementPainter{
    public LinkPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics2D g, Element element) {

    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}
