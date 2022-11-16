package main.java.dsw.gerumap.app.repository.factory.factoryImplementation;

import lombok.NoArgsConstructor;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.implementation.Element;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

@NoArgsConstructor
public class ElementFactory  extends NodeFactory {
    @Override
    public MapNode createNode(MapNode node) {
        return new Element("Element" + ((MindMap) node).getChildren().size(), node);
    }
}

