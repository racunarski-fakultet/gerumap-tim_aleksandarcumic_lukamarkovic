package main.java.dsw.gerumap.app.error;

import main.java.dsw.gerumap.app.message.implementation.Message;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class FileLogger implements ErrorLogger {

    String text;
    List<String> allErrors;

    public FileLogger(){
        allErrors = new ArrayList<>();
    }

    @Override
    public void log(Message m) {
        text = m.getContent();
        writeInFile(allErrors);
    }

    public void writeInFile(List<String> allErrors){
        allErrors.add(text);

        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/log.txt"), "UTF-8"))){
            for(String s : allErrors){
                writer.write(s);
                writer.write("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
