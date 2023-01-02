package main.java.dsw.gerumap.app.serializer;

import com.google.gson.Gson;
import main.java.dsw.gerumap.app.core.Serializer;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import java.io.*;

public class GsonSerializer implements Serializer {
    private final Gson gson = new Gson();
    @Override
    public Project loadProject(File file) {
        try(FileReader fileReader = new FileReader(file)){
            return gson.fromJson(fileReader, Project.class);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project p) {
        try(FileWriter writer = new FileWriter(p.getFilePath())){
            gson.toJson(p, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
