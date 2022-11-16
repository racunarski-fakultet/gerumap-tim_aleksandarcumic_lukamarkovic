package main.java.dsw.gerumap.app.message.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.controller.error.ErrorShow;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.MessageGenerator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class MessageGeneratorImplementation implements MessageGenerator {
    List<Object> subscribers = new ArrayList<>();
    EventType et;
    private Message m;

    @Override
    public void generate(EventType eventType) {
        if(eventType.equals(EventType.CANNOTADDCHILD)){
            m = new Message("Ne mozete da dodate dete elementu.", EventType.CANNOTADDCHILD);
            ErrorShow es = new ErrorShow(MainFrame.getInstance(), "Error", true, m);
        }else if (eventType.equals(EventType.DELETEPROJEXPL)){
            m = new Message("Ne mozete da obrisete Project Explorer.", EventType.DELETEPROJEXPL);
            ErrorShow es = new ErrorShow(MainFrame.getInstance(), "Error", true, m);
        }else if (eventType.equals(EventType.NAMECANNOTBEEMPTY)){
            System.out.println("Usao je u if koji treba.");
            m = new Message("Ne mozete da ostavite ime prazno.", EventType.NAMECANNOTBEEMPTY);
            ErrorShow es = new ErrorShow(MainFrame.getInstance(), "Error", true, m);
        }else if (eventType.equals(EventType.NODECANNOTBEDELETED)){
            subscribers.notify();
        }else{
            subscribers.notify();
            System.out.println("Generate je uspeo.");
        }
    }

    @Override
    public void addSubscriber(Object obj) {
        subscribers.add(obj);
    }

    @Override
    public void removeSubscriber(Object obj) {
        subscribers.remove(obj);
    }

}
