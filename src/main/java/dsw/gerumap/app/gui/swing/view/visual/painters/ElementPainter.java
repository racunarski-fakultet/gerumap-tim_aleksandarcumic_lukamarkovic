package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Element;

import java.awt.*;
@Setter
@Getter

/**
 * ElementPainter je apstraktna klasa koja deklariše metode za iscrtavnje Diagram
 * elementa i detekciju pogotka
 * @author Igor Z.
 *
 */
public abstract class ElementPainter extends Element {

    protected Shape shape;
    public ElementPainter(Element element) {	}

    public abstract void draw(Graphics2D g, Element element);

    public abstract boolean elementAt(Element element, Point pos);


}
