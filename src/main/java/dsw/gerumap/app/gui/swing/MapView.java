package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapView extends JPanel implements Subscriber{
    private MindMap mindMap;

    private List<ElementPainter> painters;


    public MapView(MindMap mindMap){
        this.mindMap= mindMap;
        painters = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(ElementPainter p : painters){
            p.draw(g);
        }
    }

    private class MouseController extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            if(e.getButton() == MouseEvent.BUTTON1){
                Point position = e.getPoint();
                GeneralPath gp = new GeneralPath();

                Paint fill = new Color(255, 255, 255);


            }
        }
    }

    @Override
    public void update(Object obj) {
        repaint();
    }
}
