package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.view.controller.MouseController;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.Element;
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
    MouseController mouseController;
    private JLabel lbl;
    private int index;
    private List<ElementPainter> painters;


    public MapView(MindMap mindMap, int index){
        setLayout(new FlowLayout());
        lbl = new JLabel("");
        this.index = index;
        add(lbl);
        setMap(mindMap);
//        this.mindMap= mindMap;
        painters = new ArrayList<>();
        addMouseListener(new MouseController(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(ElementPainter p : painters){
            for(MapNode mn : mindMap.getChildren()) {
                p.draw(g, (Element) mn);
            }
        }
    }

    public void setMap(MindMap map){
        this.mindMap = map;
        this.updateLabel();
        this.updateTabName();
        this.mindMap.addSubscriber(this);
    }

    public void updateLabel(){
        this.lbl.setText(this.mindMap.getName());
    }

    public void updateTabName(){
        JTabbedPane tP = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
        if(tP == null){
            return;
        }
        tP.setTitleAt(index, mindMap.getName());
    }

    @Override
    public void update(Object obj) {
        if(mindMap == null){
            return;
        }
        updateLabel();
        repaint();
    }
}
