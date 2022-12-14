package main.java.dsw.gerumap.app.repository.factory.factoryImplementation;

import lombok.NoArgsConstructor;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;
import main.java.dsw.gerumap.app.repository.implementation.Project;

@NoArgsConstructor
public class MindMapFactory extends NodeFactory {

    @Override
    public MapNode createNode(MapNode node) {
        return new MindMap("MindMap" + ((Project) node).getChildren().size(), node);
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
