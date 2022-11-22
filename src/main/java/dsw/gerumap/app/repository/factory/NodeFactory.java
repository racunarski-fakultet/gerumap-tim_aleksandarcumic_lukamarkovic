package main.java.dsw.gerumap.app.repository.factory;

import main.java.dsw.gerumap.app.repository.composite.MapNode;

public abstract class NodeFactory extends MapNode{
    public MapNode getNode(MapNode parent){
        MapNode n = createNode(parent);
        n.setParent(parent);
        return n;
    }

    public abstract MapNode createNode(MapNode node);

}
