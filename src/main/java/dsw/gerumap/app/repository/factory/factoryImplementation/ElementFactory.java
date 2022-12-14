package main.java.dsw.gerumap.app.repository.factory.factoryImplementation;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.implementation.Element;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

public class ElementFactory extends NodeFactory{

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscriber(Object obj) {

    }

    @Override
    public MapNode createNode(MapNode node) {
        return new Element("Element" + ((MindMap) node).getChildren().size(), node);
    }
}
