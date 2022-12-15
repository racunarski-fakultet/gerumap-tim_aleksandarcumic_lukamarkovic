package main.java.dsw.gerumap.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.state.model.SelectState;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class SelectedItems implements Publisher {
    List<Element> elements;

    public SelectedItems(){
        elements = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public void notifySubscriber(Object obj) {

    }
}
