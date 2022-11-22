package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;

import javax.swing.*;
import java.io.IOException;

@Getter
@Setter
public class MapView extends JPanel implements Subscriber {

    private MindMap mindMap;

    public MapView(MindMap mindMap){

        this.mindMap= mindMap;
    }


    @Override
    public void update(Object obj) {

    }
}
