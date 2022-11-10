package main.java.dsw.gerumap.app;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.core.Gui;
import main.java.dsw.gerumap.app.gui.swing.SwingGui;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;

    private AppCore(){

    }

    public static AppCore getInstance(){
        if(instance==null) {
            instance = new AppCore();
        }
        return instance;
    }

    public void run(){ this.gui.start(); }

    public static void main(String[] args) {

        Gui gui = new SwingGui();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui);
        appCore.run();

    }

}
