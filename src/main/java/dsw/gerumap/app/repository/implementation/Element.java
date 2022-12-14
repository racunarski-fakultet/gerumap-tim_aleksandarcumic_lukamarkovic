package main.java.dsw.gerumap.app.repository.implementation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.composite.MapNode;

import java.awt.*;

@Setter
@Getter
@NoArgsConstructor

public class Element extends MapNode {

    private int stroke = 2;
    private Color color = Color.BLACK;

    public Element(Color color, int stroke){
        this.color = color;
        this.stroke = stroke;
    }

    public Element(String name, MapNode parent){
        super(name, parent);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (subscriber == null || subs.contains(subscriber))
            return;
        subs.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscriber == null || !subs.contains(subscriber))
            return;
        subs.remove(subscriber);
    }

    @Override
    public void notifySubscriber(Object obj) {
        if (obj == null || subs.isEmpty()) {
            return;
        }

        for (Subscriber subscriber:subs)
            subscriber.update(obj);
    }
}
