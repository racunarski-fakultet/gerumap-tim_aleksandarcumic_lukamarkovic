package main.java.dsw.gerumap.app.repository.implementation;

import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof MapaUma){
            MapaUma mapaUma = (MapaUma) child;
            if (!this.getChildren().contains(mapaUma)){
                this.getChildren().add(mapaUma);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null &&  child instanceof MapaUma && this.getChildren()!=null){
            MapaUma mapaUma = (MapaUma) child;
            if (!this.getChildren().contains(mapaUma)){
                this.getChildren().remove(mapaUma);
            }
        }
    }
}
