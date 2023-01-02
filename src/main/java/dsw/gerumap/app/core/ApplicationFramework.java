package main.java.dsw.gerumap.app.core;

//@Setter
//@NoArgsConstructor

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.error.ErrorLogger;

@Getter
@Setter
public class ApplicationFramework {

    protected MessageGenerator mg;

    protected Gui gui;

    protected MapRepository mapRepository;

    protected ErrorLogger cl;
    protected ErrorLogger fl;
    private Serializer serializer;

    public void run (){
        this.gui.start();
    }

    public void initialise (Gui gui, MapRepository mapRepository, MessageGenerator mg, ErrorLogger cl, ErrorLogger fl, Serializer serializer) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.mg = mg;
        this.cl = cl;
        this.fl = fl;
        this.serializer = serializer;
    }


    private static ApplicationFramework instance;
    public static ApplicationFramework getInstance(){

        if(instance==null) {
            instance = new ApplicationFramework();
        }
        return instance;

    }

}
