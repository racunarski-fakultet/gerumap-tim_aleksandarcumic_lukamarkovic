package main.java.dsw.gerumap.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.composite.MapNode;

import java.awt.*;
@Setter
@Getter

public class Element extends MapNode {
    int stroke = 2;
    Color color;
    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element() {
        color = Color.BLACK;
    }
}
