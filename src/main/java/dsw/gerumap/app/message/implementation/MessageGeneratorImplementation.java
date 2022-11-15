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

    private List<MessageGenerator> subscribers = new ArrayList<>();
    private Message m;

    @Override
    public void generate(EventType eventType) {
        if(eventType.equals(EventType.CANNOTADDCHILD)){
            notify();
        }else if (eventType.equals(EventType.DELETEPROJEXPL)){
            m = new Message("Uspelo je", eventType);
        }else if (eventType.equals(EventType.NAMECANNOTBEEMPTY)){
            notify();
        }else if (eventType.equals(EventType.NODECANNOTBEDELETED)){
            notify();
        }else{
            notify();
        }
    }

    public void addSubscriber(MessageGenerator mg) {
        subscribers.add(mg);
    }

    public void removeSubscriber(MessageGenerator mg) {
        subscribers.remove(mg);
    }

    public void setMessage(Message m){
        this.m = m;
        for(MessageGenerator mg : this.subscribers){
            mg.generate(this.m.et);
        }
    }

}
