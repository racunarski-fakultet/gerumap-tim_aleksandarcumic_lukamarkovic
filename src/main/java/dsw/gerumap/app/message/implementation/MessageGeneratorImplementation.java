package main.java.dsw.gerumap.app.message.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.message.ErrorType;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.core.MessageGenerator;

import java.io.IOException;
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
    public void generate(EventType type) throws IOException {
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
            m = new Message("Ne mozete da ostavite ime prazno.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.NODECANNOTBEDELETED)){
            m = new Message("Cvor ne moze biti obrisan.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.NODEALREADYEXISTS)){
            m = new Message("Cvor vec postoji.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.AUTHORPROJECTNOTSELECTED)){
            m = new Message("Autor projekta nije selektovan.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.CANNOTDELETEFILE)){
            m = new Message("Fajl ne moze biti obrisan.", ErrorType.ERROR);
            return m;
        }else if (eventType.equals(EventType.NODENOTSELECTED)){
            m = new Message("Nije selektovan niti jedan cvor.", ErrorType.ERROR);
        }else{
            m = new Message("Ova greska nije obradjena.", ErrorType.ERROR);
        }
        return m;
    }

    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null){
            return;
        }
        if(this.subscribers== null){
            subscribers = new ArrayList<>();
        }
        if(this.subscribers.contains(subscriber)){
            return;
        }

        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || this.subscribers.contains(subscriber)){
            return;
        }
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(Object obj)  {
        if (obj == null || this.subscribers==null || this.subscribers.isEmpty()) {
            System.out.println(subscribers.size());
            return;
        }

        for (Subscriber subscriber:subscribers)
            subscriber.update(obj);
    }


}
