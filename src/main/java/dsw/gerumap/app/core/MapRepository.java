package main.java.dsw.gerumap.app.core;

import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.repository.implementation.ProjectExplorer;

public interface MapRepository {

    ProjectExplorer getProjectExplorer();

    Void addChild(MapNodeComposite parent, MapNode child);


}
