package main.java.dsw.gerumap.app.gui.swing.view.visual.painters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
@Setter
@Getter
@NoArgsConstructor
public abstract class ElementPainter {

    private Element element;

    public ElementPainter(Element element){this.element = element;}

    public abstract void draw(Graphics g);

    public abstract boolean elementAt(Point pos);


}
