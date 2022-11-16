package main.java.dsw.gerumap.app.message.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.message.ErrorType;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.core.MessageGenerator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class MessageGeneratorImplementation implements MessageGenerator {
    private List<Subscriber> subscribers;
    EventType et;
    private Message m;

    public MessageGeneratorImplementation(){
        this.subscribers = new ArrayList<>();
    }
    @Override
    public void generate(EventType type) {
        System.out.println(subscribers.size());
        System.out.println("generate");
        notifySubscriber(createMessage(type));
    }

    public Message createMessage(EventType eventType) {
        if(eventType.equals(EventType.CANNOTADDCHILD)){
            m = new Message("Ne mozete da dodate dete elementu.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.DELETEPROJEXPL)){
            m = new Message("Ne mozete da obrisete Project Explorer.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.NAMECANNOTBEEMPTY)){
            System.out.println("Usao je u if koji treba.");
            m = new Message("Ne mozete da ostavite ime prazno.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.NODECANNOTBEDELETED)){

        }else{
            System.out.println("Generate je uspeo.");
        }
        return m;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null || subscribers.contains(subscriber)){
            return;
        }
        System.out.println("addedsub");
        subscribers.add(subscriber);
        System.out.println(subscribers.size());
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || subscribers.isEmpty()){
            return;
        }
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(Object obj) {
        if (obj == null || subscribers.isEmpty()) {
            System.out.println(subscribers.size());
            return;
        }

        for (Subscriber subscriber:subscribers)
            subscriber.update(obj);
    }


}
