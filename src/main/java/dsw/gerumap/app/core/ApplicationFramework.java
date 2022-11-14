package main.java.dsw.gerumap.app.core;

//@Setter
//@NoArgsConstructor

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationFramework {



    protected Gui gui;

    protected MapRepository mapRepository;





    public void run (){
        this.gui.start();
    }

    public void initialise (Gui gui, MapRepository mapRepository) {

        this.gui = gui;
        this.mapRepository = mapRepository;
    }


    private static ApplicationFramework instance;
    public static ApplicationFramework getInstance(){

        if(instance==null) {
            instance = new ApplicationFramework();
        }
        return instance;

    }

}
