package main.java.dsw.gerumap.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Project extends MapNodeComposite implements Publisher {

    private transient List<Subscriber> subscribers;
    private String author;
    protected boolean changed = true;
    protected String filePath;

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if (!this.getChildren().contains(mindMap)){
                this.getChildren().add(mindMap);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null &&  child instanceof MindMap && this.getChildren()!=null){
            MindMap mindMap = (MindMap) child;
            if (!this.getChildren().contains(mindMap)){
                this.getChildren().remove(mindMap);
            }
        }
    }

    public void setAuthor(String name) {
        author = name;
        notifySubscriber(this);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null){
            return;
        }
        if(this.subscribers == null){
            subscribers = new ArrayList<>();
        }
        if(this.subscribers.contains(subscriber)){
            return;
        }

        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || this.subscribers.contains(subscriber)){
            return;
        }
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(Object obj)  {
        if (obj == null || this.subscribers==null || this.subscribers.isEmpty()) {
            System.out.println(subscribers.size());
            return;
        }

        for (Subscriber subscriber:subscribers)
            subscriber.update(obj);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed = true;
    }
}
