package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.view.controller.MouseController;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
public class MapView extends JPanel implements Subscriber {

    MouseController mouseController;
    private MindMap mindMap;

    private List<ElementPainter> painters;


    public MapView(MindMap mindMap){
        this.mindMap= mindMap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    @Override
    public void update(Object obj) {
        repaint();
    }
}
