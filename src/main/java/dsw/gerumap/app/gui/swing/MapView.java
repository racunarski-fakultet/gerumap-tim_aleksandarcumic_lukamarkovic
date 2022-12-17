package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.view.controller.MouseController;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapView extends JPanel implements Subscriber{




    double translateX = 0;
    double translateY = 0;
    double scalingf = 1;

    private AffineTransform transformation = new AffineTransform();

    private MindMap mindMap;
    MouseController mouseController;



    private JScrollPane scrollPane;

    private JLabel lbl;
    private int index;
    private List<ElementPainter> painters;

    private SelectedItems selectedItems;

    public MapView(MindMap mindMap, int index){
        setLayout(new BorderLayout());
        lbl = new JLabel("");
        this.index = index;
        add(lbl,BorderLayout.NORTH);

        scrollPane = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);



        //add(scrollPane);


        setMap(mindMap);


        painters = new ArrayList<>();
        selectedItems = new SelectedItems();
        addMouseListener(new MouseController(this));
        addMouseMotionListener(new MouseController(this));
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ((Graphics2D) g).setTransform(transformation);
        for(ElementPainter p : painters){
            for(MapNode mn : mindMap.getChildren()) {
                p.draw(g);
            }
        }

        System.out.println("paint");
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



    private void setUpTransformation(){
        transformation.setToScale(scalingf,scalingf);
        transformation.translate(translateX,translateY);

        repaint();
    }

    public void zoomIn(){
        scalingf *= 1.6;
        if(scalingf > 4.096) scalingf = 4.096;
        setUpTransformation();

    }
    public void zoomOut(){
        scalingf *= 0.625;
        if(scalingf < 0.390625) scalingf = 0.390625;
        setUpTransformation();
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
