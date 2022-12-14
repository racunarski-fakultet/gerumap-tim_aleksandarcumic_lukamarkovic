package main.java.dsw.gerumap.app.repository.factory.factoryImplementation;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.implementation.Project;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class ProjectFactory extends NodeFactory {

    public ProjectFactory() {
    }

    @Override
    public MapNode createNode(MapNode node) {
        return new Project("Project" + ((ProjectExplorer) node).getChildren().size(), node);
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
