package main.java.dsw.gerumap.app.repository.factory.factoryImplementation;

import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;

public class ProjectFactory extends NodeFactory {
    public ProjectFactory(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public MapNode createNode(String name) {
        return null;
    }
}
