package main.java.dsw.gerumap.app.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.dsw.gerumap.app.core.Serializer;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;

public class GsonSerializer implements Serializer {
    private Gson gson = new Gson();


    @Override
    public void saveProject(Project project) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting().registerTypeAdapter(MapNode.class, new AbstractElementAdapter());
        gson = gsonBuilder.create();
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project loadProject(File file) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting().registerTypeAdapter(MapNode.class, new AbstractElementAdapter());
        gson = gsonBuilder.create();

//        Type fooType = new TypeToken<List<MapNode>>() {}.getType();
        try (FileReader fileReader = new FileReader(file)) {
            return (Project) gson.fromJson(fileReader, MapNode.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
