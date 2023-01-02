package main.java.dsw.gerumap.app.gui.swing.commands.implementation;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;

public class AddLinkCommand extends AbstractCommand {

    private Concept c1;
    private Concept c2;
    private MapView map;
    private ElementPainter painter;
    private Link link;

    public AddLinkCommand(Concept c1, Concept c2, MapView map, ElementPainter painter, Link link){
        this.c1 = c1;
        this.c2 = c2;
        this.map = map;
        this.painter = painter;
        this.link = link;
    }

    @Override
    public void doCommand() {
        c1.getLinkList().add((LinkPainter) painter);
        c2.getLinkList().add((LinkPainter) painter);
        map.getMindMap().addChild(link);
        if(!map.getMindMap().getPainters().contains(painter)){
            map.getMindMap().getPainters().add(painter);
        }
    }

    @Override
    public void undoCommand() {
        c1.getLinkList().remove((LinkPainter) painter);
        c2.getLinkList().remove((LinkPainter) painter);
        map.getMindMap().removeChild(link);
        map.getMindMap().getPainters().remove(painter);
    }
}
