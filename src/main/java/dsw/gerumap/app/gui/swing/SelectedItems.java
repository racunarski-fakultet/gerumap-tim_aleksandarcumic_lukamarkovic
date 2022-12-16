package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.state.model.SelectState;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class SelectedItems implements Publisher {
    private List<Element> elements;
    protected List<Subscriber> subscribers;
    private Color oldColor;

    public SelectedItems(){
        elements = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void addElement(Element el){
        if (el != null) {
            this.getElements().add(el);
            oldColor = el.getColor();
            el.setColor(Color.BLUE);
            notifySubscriber(this);
        }
    }

    public void clearList(){
        for(Element el : this.getElements()){
            el.setColor(oldColor);
        }
        getElements().clear();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(subscriber))
            return;
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
            return;
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber (Object obj) {
        if(obj == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(Subscriber sub : subscribers){
            sub.update(obj);
        }
    }
}
