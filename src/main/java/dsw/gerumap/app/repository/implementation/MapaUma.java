package main.java.dsw.gerumap.app.repository.implementation;


import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;

public class MapaUma extends MapNodeComposite {

    public MapaUma(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Element){
            Element element = (Element) child;
            if (!this.getChildren().contains(element)){
                this.getChildren().add(element);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null &&  child instanceof Element){
            Element element = (Element) child;
            if (!this.getChildren().contains(element)){
                this.getChildren().remove(element);
            }
        }
    }
}