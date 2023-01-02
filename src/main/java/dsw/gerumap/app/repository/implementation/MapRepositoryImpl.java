package main.java.dsw.gerumap.app.repository.implementation;


import main.java.dsw.gerumap.app.core.MapRepository;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;
import lombok.Getter;
import lombok.Setter;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        if(child!=null){
            parent.addChild(child);
        }
    }
}
