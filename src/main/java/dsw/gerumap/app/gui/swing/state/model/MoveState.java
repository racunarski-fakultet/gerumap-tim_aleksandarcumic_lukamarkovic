package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;

import java.awt.*;

public class MoveState implements State {

    int flag = 0;
    int pocetnoX;
    int pocetnoY;
    @Override
    public void misPovucen(int x, int y, MapView map) {
        if (flag == 1) {
            for(ElementPainter p : map.getPainters()){
                if(p.getElement() instanceof Concept){
                    Concept t = (Concept) p.getElement();
                    if (map.getSelectedItems().getElements().contains(t)) {
                        t.setX(t.getX() - (pocetnoX - x));
                        t.setY(t.getY() - (pocetnoY - y));
                        for(LinkPainter painter : t.getLinkList()){
                            Link con = (Link) painter.getElement();
                            if(con.getTo().equals(t)){
                                Point pos1 = new Point(painter.getPos1().x - (pocetnoX - x), painter.getPos1().y - (pocetnoY - y));
                                painter.setPos1(pos1);
                            }else{
                                Point pos2 = new Point(painter.getPos2().x - (pocetnoX - x), painter.getPos2().y - (pocetnoY - y));
                                painter.setPos2(pos2);
                            }
                        }
                    }
                }
            }
            pocetnoX -= pocetnoX - x;
            pocetnoY -= pocetnoY - y;
        }

        map.repaint();
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {

        Point point = new Point(x, y);
        for(ElementPainter p : map.getPainters()) {
            if (p.getElement() instanceof Concept) {
                Concept c = (Concept) p.getElement();
                if (map.getSelectedItems().getElements().contains(c)) {

                    if (p.elementAt(point)) {
                        pocetnoX = x;
                        pocetnoY = y;
                        flag = 1;
                        break;
                    }else{
                        flag=0;
                    }
                }
            }
        }
    }
}
