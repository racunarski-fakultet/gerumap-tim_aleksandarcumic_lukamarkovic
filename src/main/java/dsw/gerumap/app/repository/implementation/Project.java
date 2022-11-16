package main.java.dsw.gerumap.app.repository.implementation;

import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

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
}
