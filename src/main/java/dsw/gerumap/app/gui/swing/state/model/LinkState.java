package main.java.dsw.gerumap.app.gui.swing.state.model;

import javafx.scene.shape.Line;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class LinkState implements State {

    Concept c1;
    Concept c2;
    private LinkPainter linkPainter;
    private Link link;
    List<ElementPainter> nova = new ArrayList<>();
    private Point pos1;
    private Point pos2;

    @Override
    public void misPovucen(int x, int y, MapView map) {
        pos2.setLocation(x, y);
        map.update(linkPainter);
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {
        pos2.setLocation(x, y);



        for(ElementPainter p : map.getPainters()){

            if(p.elementAt(pos2) && p.getElement() instanceof Concept){
                linkPainter.setPos2(pos2);

                c2 = (Concept) p.getElement();
                link.setSecondTopic(c2);


            }
        }

        if(c1.equals(c2)){
            map.getPainters().remove(linkPainter);
        }

        for(LinkPainter painter : c1.getLinkList()){
            Link l1 = (Link) painter.getElement();
            if(l1.equals(link)){
                map.getPainters().remove(linkPainter);
                map.update(this);
                return;
            }
        }

        for(LinkPainter painter : c2.getLinkList()){
            Link l1 = (Link) painter.getElement();
            if(l1.equals(link)){
                map.getPainters().remove(linkPainter);
                map.update(this);
                return;
            }
        }
        c1.getLinkList().add(linkPainter);
        c2.getLinkList().add(linkPainter);
        map.getMindMap().addChild(link);
    }

    @Override
    public void misKliknut(int x, int y, MapView map) {
        pos1 = new Point(x, y);
        pos2 = new Point(x, y);
        nova.clear();

        for(ElementPainter p : map.getPainters()){
            if(p.elementAt(pos1)){
                c1 = (Concept) p.getElement();
                c2 = (Concept) p.getElement();

                link = new Link("Link + " + map.getMindMap().getChildren().size(), c1.getParent(), Color.BLACK, 2, c1, c2);

                linkPainter = new LinkPainter(pos1, pos2, link);
                nova.add(linkPainter);
            }
        }

        for(ElementPainter n : nova){
            map.getPainters().add(n);
        }

    }
}
