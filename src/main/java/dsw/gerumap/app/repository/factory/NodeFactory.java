package main.java.dsw.gerumap.app.repository.factory;

import main.java.dsw.gerumap.app.repository.composite.MapNode;

public abstract class NodeFactory extends MapNode {
    public NodeFactory(String name, MapNode parent) {
        super(name, parent);
    }

    public MapNode getNode(String name){
        MapNode n = createNode(name);
        n.setName(getName());
        n.setParent(getParent());
        return n;
    }

    public abstract MapNode createNode(String name);
}
