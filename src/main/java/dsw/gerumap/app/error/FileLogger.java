package main.java.dsw.gerumap.app.error;

import main.java.dsw.gerumap.app.message.implementation.Message;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ErrorLogger {

    File file;
    @Override
    public void log(Message m) {
        file =  new File("/resources/fajl.txt");

        String str = m.toString();
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Treba imati File f u kom ce biti ispisana
    //ista poruka kao u ConsoleLoggeru
}
