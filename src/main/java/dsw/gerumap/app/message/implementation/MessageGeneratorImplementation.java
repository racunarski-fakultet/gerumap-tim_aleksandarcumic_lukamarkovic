package main.java.dsw.gerumap.app.message.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.MessageGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

@Getter
@Setter

public class MessageGeneratorImplementation implements MessageGenerator {
    List<Object> subscribers = new ArrayList<>();

    private Message m;

    @Override
    public void generate(EventType eventType) {
        if(eventType.equals(EventType.CANNOTADDCHILD)){
            notify();
        }else if (eventType.equals(EventType.DELETEPROJEXPL)){
            notify();
        }else if (eventType.equals(EventType.NAMECANNOTBEEMPTY)){
            notify();
        }else if (eventType.equals(EventType.NODECANNOTBEDELETED)){
            notify();
        }else{
            notify();
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
