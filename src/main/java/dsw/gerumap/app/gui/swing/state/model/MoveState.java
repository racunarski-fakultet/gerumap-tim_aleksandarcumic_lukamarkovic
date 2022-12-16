package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;

import java.awt.*;

public class MoveState implements State {

    int flag = 0;
    @Override
    public void misPovucen(int x, int y, MapView map) {
        for(ElementPainter p : map.getPainters()){
            Concept c = (Concept) p.getElement();
            if(map.getSelectedItems().getElements().contains(c)){
                if(flag == 1){
                    c.setX(x);
                    c.setY(y);
                }
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {
        Point point = new Point(x, y);
        for(ElementPainter p : map.getPainters()){
            Concept c = (Concept) p.getElement();
            if(map.getSelectedItems().getElements().contains(c)){
                if(p.elementAt(point)){
                    flag = 1;
                }
            }
        }
    }
}
