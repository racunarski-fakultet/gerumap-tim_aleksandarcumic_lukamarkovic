package main.java.dsw.gerumap.app.repository.implementation;


import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class MindMap extends MapNodeComposite {

    private boolean template;
    public MindMap(String name, MapNode parent) {
        super(name, parent);
        elements = new ArrayList<>();
    }

    public List<Element> elements;

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof Element){
            Element element = (Element) child;
            this.getChildren().add(element);
            notifySubscriber(this);
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if(child != null && child instanceof Element){
            Element element = (Element) child;
            this.getChildren().remove(element);
            notifySubscriber(this);
        }
    }
    public MindMap(String name, MapNode parent, boolean template) {
        super(name, parent);
        this.template = template;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null || subs.contains(subscriber)){
            return;
        }
        subs.add(subscriber);
        System.out.println(subscriber.toString());
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || !subs.contains(subscriber)){
            return;
        }
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscriber(Object obj) {
        if(obj == null || subs.isEmpty()){
            return;
        }
        for(Subscriber subscriber : subs){
            subscriber.update(obj);
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
