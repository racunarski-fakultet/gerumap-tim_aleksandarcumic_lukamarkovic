package main.java.dsw.gerumap.app.repository.factory.factoryImplementation;

import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;

public class ElementFactory extends NodeFactory {

    public ElementFactory(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public MapNode createNode(String name) {
        return null;
    }
}
