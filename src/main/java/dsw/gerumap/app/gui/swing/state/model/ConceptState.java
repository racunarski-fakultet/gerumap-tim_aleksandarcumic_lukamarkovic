package main.java.dsw.gerumap.app.gui.swing.state.model;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.commands.implementation.AddChildCommand;
import main.java.dsw.gerumap.app.gui.swing.commands.implementation.AddConceptCommand;
import main.java.dsw.gerumap.app.gui.swing.state.State;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ConceptPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class ConceptState implements State {



    @Override
    public void misPovucen(int x, int y, MapView map) {

    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misKliknut(int x, int y, MapView map) {
        Point point = new Point(x, y);
        int flag = 0;
        for(ElementPainter p : map.getMindMap().getPainters()){
            if(p.elementAt(point)){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            x += 20;
            y += 20;
        }

        //String name = JOptionPane.showInputDialog(MainFrame.getInstance(), "Input text");

//        if(name == null){
//            return;
//        }

        Concept concept = new Concept("Concept" + map.getMindMap().getChildren().size(), map.getMindMap(), Color.BLACK, 2, x, y);
//        Ellipse2D shape = new Ellipse2D.Float(concept.getX(), concept.getY(), concept.getW(), concept.getH());
        ConceptPainter cP = new ConceptPainter(concept);
        concept.addSubscriber(map);

        AbstractCommand command = new AddConceptCommand(map, cP);
        ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);
//        map.getPainters().add(cP);
//        map.getMindMap().addChild(concept);
    }

}
