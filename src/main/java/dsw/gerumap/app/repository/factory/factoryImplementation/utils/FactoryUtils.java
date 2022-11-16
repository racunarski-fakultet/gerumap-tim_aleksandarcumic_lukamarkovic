package main.java.dsw.gerumap.app.repository.factory.factoryImplementation.utils;

import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.factory.NodeFactory;
import main.java.dsw.gerumap.app.repository.factory.factoryImplementation.ElementFactory;
import main.java.dsw.gerumap.app.repository.factory.factoryImplementation.MindMapFactory;
import main.java.dsw.gerumap.app.repository.factory.factoryImplementation.ProjectFactory;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;
import main.java.dsw.gerumap.app.repository.implementation.Project;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

public class FactoryUtils {

    public static NodeFactory getNodeFactory(MapNode parent) {

        if(parent instanceof ProjectExplorer){
            return new ProjectFactory();
        }else if(parent instanceof Project){
            return new MindMapFactory();
        }else if(parent instanceof MindMap){
            return new ElementFactory();
        }

        return null;
    }
}
