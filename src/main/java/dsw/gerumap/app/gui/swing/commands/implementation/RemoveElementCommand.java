package main.java.dsw.gerumap.app.gui.swing.commands.implementation;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.util.List;

public class RemoveElementCommand extends AbstractCommand {

    private List<ElementPainter> painters;
    private MapView map;

    public RemoveElementCommand(List<ElementPainter> painters, MapView map){
        this.painters = painters;
        this.map = map;
    }

    @Override
    public void doCommand() {
        for(ElementPainter p : painters){
            map.getMindMap().removeChild(p.getElement());
            map.getSelectedItems().getElements().remove(p.getElement());
            map.getMindMap().getPainters().remove(p);
        }
    }

    @Override
    public void undoCommand() {
        for(ElementPainter p : painters){
            map.getMindMap().removeChild(p.getElement());
            map.getSelectedItems().getElements().add(p.getElement());
            map.getMindMap().getPainters().add(p);
        }
    }
}
