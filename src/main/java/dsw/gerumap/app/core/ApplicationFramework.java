package main.java.dsw.gerumap.app.core;

//@Setter
//@NoArgsConstructor

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.message.MessageGenerator;

@Getter
@Setter
public class ApplicationFramework {

    protected MessageGenerator mg;

    protected Gui gui;

    protected MapRepository mapRepository;


    public void run (){
        this.gui.start();
    }

    public void initialise (Gui gui, MapRepository mapRepository, MessageGenerator mg) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.mg = mg;
    }


    private static ApplicationFramework instance;
    public static ApplicationFramework getInstance(){

        if(instance==null) {
            instance = new ApplicationFramework();
        }
        return instance;

    }

}
