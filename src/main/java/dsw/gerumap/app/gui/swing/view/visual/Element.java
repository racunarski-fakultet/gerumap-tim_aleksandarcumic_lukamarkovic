package main.java.dsw.gerumap.app.gui.swing.view.visual;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class Element {
    Stroke stroke;
    Color colour;

    public Element(){
        this.stroke = new BasicStroke();
        this.colour = Color.BLACK;
    }
}
