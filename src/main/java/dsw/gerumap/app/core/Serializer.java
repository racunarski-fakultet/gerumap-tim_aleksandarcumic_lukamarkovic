package main.java.dsw.gerumap.app.core;

import main.java.dsw.gerumap.app.repository.implementation.Project;

import java.io.File;

public interface Serializer {
    Project loadProject(File file);
    void saveProject(Project p);
}
