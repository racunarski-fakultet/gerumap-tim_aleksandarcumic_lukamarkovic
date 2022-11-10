package main.java.dsw.gerumap.app.repository;

import main.java.dsw.gerumap.app.core.MapRepository;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;


public class MapRepositoryImpl extends MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    public void addChild(MapNodeComposite parent, MapNode child) {
        //TODO: implement add Child method
    }
}
