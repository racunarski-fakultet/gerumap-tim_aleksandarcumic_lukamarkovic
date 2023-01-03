package main.java.dsw.gerumap.app.gui.swing.commands.implementation;


import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MoveCommand extends AbstractCommand {

    private MapView map;
    private List<ElementPainter> stoke;
    private int x;
    private int y;
    private int pocetnoX;
    private int pocetnoY;
    private int flag = 0;

    public MoveCommand(MapView map, List<ElementPainter> stoke, int x, int y, int pocetnoX, int pocetnoY) {
        this.map = map;
        this.stoke = stoke;
        this.x = x;
        this.y = y;
        this.pocetnoX = pocetnoX;
        this.pocetnoY = pocetnoY;
    }

    @Override
    public void doCommand(){

        if (flag > 0) {
            for (ElementPainter p : map.getMindMap().getPainters()) {
                if (p.getElement() instanceof Concept) {
                    Concept t = (Concept) p.getElement();
                    if (stoke.contains(p)) {
                        t.setX(t.getX() - (pocetnoX - x));
                        t.setY(t.getY() - (pocetnoY - y));
                        for (LinkPainter painter : t.getLinkList()) {
                            Link con = (Link) painter.getElement();
                            if (con.getTo().equals(t)) {
                                Point pos1 = new Point(painter.getPos1().x - (pocetnoX - x), painter.getPos1().y - (pocetnoY - y));
                                painter.setPos1(pos1);
                            } else {
                                Point pos2 = new Point(painter.getPos2().x - (pocetnoX - x), painter.getPos2().y - (pocetnoY - y));
                                painter.setPos2(pos2);
                            }
                        }
                    }
                }
            }

        }
        flag++;
    }

    @Override
    public void undoCommand(){
        for (ElementPainter p : map.getMindMap().getPainters()) {
            if (p.getElement() instanceof Concept) {
                Concept t = (Concept) p.getElement();
                if (stoke.contains(p)) {
                    t.setX(t.getX() + (pocetnoX - x));
                    t.setY(t.getY() + (pocetnoY - y));
                    for (LinkPainter painter : t.getLinkList()) {
                        Link con = (Link) painter.getElement();
                        if (con.getTo().equals(t)) {
                            Point pos1 = new Point(painter.getPos1().x + (pocetnoX - x), painter.getPos1().y + (pocetnoY - y));
                            painter.setPos1(pos1);
                        } else {
                            Point pos2 = new Point(painter.getPos2().x + (pocetnoX - x), painter.getPos2().y + (pocetnoY - y));
                            painter.setPos2(pos2);
                        }
                    }
                }
            }
        }
    }
}