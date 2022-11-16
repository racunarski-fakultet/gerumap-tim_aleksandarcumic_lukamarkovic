package main.java.dsw.gerumap.app.core;

//@Setter
//@NoArgsConstructor

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.controller.error.ErrorFind;
import main.java.dsw.gerumap.app.message.MessageGenerator;

@Getter
@Setter
public class ApplicationFramework {

    protected MessageGenerator mg;

    protected Gui gui;

    protected MapRepository mapRepository;

    protected ErrorFind errorFind;

    public void run (){
        this.gui.start();
    }

    public void initialise (Gui gui, MapRepository mapRepository, MessageGenerator mg) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.mg = mg;
        this.errorFind = errorFind;
    }


    private static ApplicationFramework instance;
    public static ApplicationFramework getInstance(){

        if(instance==null) {
            instance = new ApplicationFramework();
        }
        return instance;

    }

}
