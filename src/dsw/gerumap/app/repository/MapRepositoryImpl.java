package dsw.gerumap.app.repository;

import dsw.gerumap.app.core.MapRepository;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;
import dsw.gerumap.app.repository.implementation.ProjectExplorer;
import lombok.Getter;
import lombok.Setter;


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
