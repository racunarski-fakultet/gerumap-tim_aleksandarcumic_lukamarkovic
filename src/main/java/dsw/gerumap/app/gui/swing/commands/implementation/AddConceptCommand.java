package main.java.dsw.gerumap.app.gui.swing.commands.implementation;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;

public class AddConceptCommand extends AbstractCommand {

    private MapView map;
    private ElementPainter painter;

    public AddConceptCommand(MapView map, ElementPainter painter){
        this.map = map;
        this.painter = painter;
    }

    @Override
    public void doCommand() {
        if(map == null || painter == null) return;

        Concept concept = (Concept) painter.getElement();
        map.getMindMap().getPainters().add(painter);
        map.getMindMap().addChild(concept);

    }

    @Override
    public void undoCommand() {
        if(map == null || painter == null) return;

        Concept concept = (Concept) painter.getElement();
        map.getMindMap().getPainters().remove(painter);
        map.getMindMap().removeChild(concept);

    }
}
