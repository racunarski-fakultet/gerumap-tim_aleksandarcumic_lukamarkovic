package main.java.dsw.gerumap.app.gui.swing.view.visual;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Concept extends Element {
    private int w = 100, h =  50;
    private int x, y;

    private int nivo=-1;

    private List<LinkPainter> linkList;

    public Concept(String name, MapNode parent, Color color, int stroke, int x, int y){
        super(name, parent, color, stroke);
        this.x = x;
        this.y = y;
        linkList = new ArrayList<>();
    }

    public void setX(int x) {
        this.x = x;
        notifySubscriber(this);
    }

    public void setY(int y) {
        this.y = y;
        notifySubscriber(this);
    }

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
        notifySubscriber(this);
    }

}
