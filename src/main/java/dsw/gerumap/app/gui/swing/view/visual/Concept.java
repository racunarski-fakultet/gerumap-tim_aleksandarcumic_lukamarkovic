package main.java.dsw.gerumap.app.gui.swing.view.visual;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

@Getter
@Setter

public class Concept extends Element {
    private String name;
    private int w = 100, h =  50;
    private int x, y;

    public Concept(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
