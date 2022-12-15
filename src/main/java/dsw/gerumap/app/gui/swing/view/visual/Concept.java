package main.java.dsw.gerumap.app.gui.swing.view.visual;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;

@Getter
@Setter

public class Concept extends Element {
    private int w = 100, h =  50;
    private int x, y;

    public Concept(String name, MapNode parent, Color color, int stroke, int x, int y){
        super(name, parent, color, stroke);
        this.x = x;
        this.y = y;
    }
}
