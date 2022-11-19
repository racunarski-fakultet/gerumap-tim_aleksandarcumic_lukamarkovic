package main.java.dsw.gerumap.app.error;

import main.java.dsw.gerumap.app.message.implementation.Message;

import java.io.*;
import java.nio.Buffer;

public class FileLogger implements ErrorLogger {

    String text;

    @Override
    public void log(Message m) {
        text = m.getContent();
        writeInFile();
    }

    public void writeInFile(){
        System.out.println("Usao je u writeInFile.");
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/log.txt"), "UTF-8"))){
            writer.write(text);
            System.out.println("Usao je u try.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
