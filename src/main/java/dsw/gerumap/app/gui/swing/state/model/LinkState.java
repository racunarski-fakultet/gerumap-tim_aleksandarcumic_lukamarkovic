package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.commands.implementation.AddLinkCommand;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;

import java.awt.*;
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


        if(c1==null || c2 ==null){

            return;
        }
        pos2.setLocation(x, y);



        for(ElementPainter p : map.getMindMap().getPainters()){

            if(p.elementAt(pos2) && p.getElement() instanceof Concept){
                Concept p1 = (Concept) p.getElement();
                pos2 = new Point(p1.getX(),p1.getY());
                linkPainter.setPos2(pos2);

                c2 = (Concept) p.getElement();
                link.setSecondTopic(c2);


            }
        }

        if(c1.equals(c2)){

            map.getMindMap().getPainters().remove(linkPainter);
            map.update(this);
            return;
        }

        for(LinkPainter painter : c1.getLinkList()){
            Link l1 = (Link) painter.getElement();
            if(l1.equals(link)){
                map.getMindMap().getPainters().remove(linkPainter);
                map.update(this);
                return;
            }
        }

        for(LinkPainter painter : c2.getLinkList()){
            Link l1 = (Link) painter.getElement();
            if(l1.equals(link)){
                map.getMindMap().getPainters().remove(linkPainter);
                map.update(this);
                return;
            }
        }

        AbstractCommand command = new AddLinkCommand(c1, c2, map, linkPainter, link);
        ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);

//        c1.getLinkList().add(linkPainter);
//        c2.getLinkList().add(linkPainter);
//        map.getMindMap().addChild(link);
    }

    @Override
    public void misKliknut(int x, int y, MapView map) {
        pos1 = new Point(x, y);
        pos2 = new Point(x, y);
        c1 = null;
        c2 = null;
        nova.clear();




        for(ElementPainter p : map.getMindMap().getPainters()){
            if(p.elementAt(pos1)){
                c1 = (Concept) p.getElement();
                c2 = (Concept) p.getElement();

                link = new Link("Link + " + map.getMindMap().getChildren().size(), c1.getParent(), Color.BLACK, 2, c1, c2);
                pos1 = new Point(c1.getX(),c1.getY());
                linkPainter = new LinkPainter(pos1, pos2, link);
                nova.add(linkPainter);
            }
        }

        for(ElementPainter n : nova){
            map.getMindMap().getPainters().add(n);
        }

    }
}
