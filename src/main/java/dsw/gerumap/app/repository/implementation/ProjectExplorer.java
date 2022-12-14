package main.java.dsw.gerumap.app.repository.implementation;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {


    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Project){
            Project project = (Project) child;
            if (!this.getChildren().contains(project)){
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (this.getChildren()!=null && child != null && child instanceof Project){
            Project project = (Project) child;
            if (!this.getChildren().contains(project)){
                this.getChildren().remove(project);
            }
        }
    }


    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscriber(Object obj) {

    }
}

