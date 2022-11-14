package main.java.dsw.gerumap.app.message.implementation;

import main.java.dsw.gerumap.app.message.ErrorType;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.MessageGenerator;

public class MessageGeneratorImplementation implements MessageGenerator {

    @Override
    public Message generate(EventType eventType) {
        if(eventType.equals(EventType.CANNOTADDCHILD)){
            return new Message("Ne mozete dodati dete elementu.", ErrorType.WARNING);
            // probati da ubacim kasnije notify();
        }else if (eventType.equals(EventType.DELETEPROJEXPL)){
            return new Message("Ne mozete obrisati project explorer.", ErrorType.ERROR);
        }else if (eventType.equals(EventType.NAMECANNOTBEEMPTY)){
            return new Message("Ime ne moze biti prazno.", ErrorType.WARNING);
        }else if (eventType.equals(EventType.NODECANNOTBEDELETED)){
            return new Message("Ovaj cvor ne moze biti obrisan", ErrorType.ERROR);
        }else{
            return new Message("Nije moguce izvrsiti ovu akciju.", ErrorType.ERROR);
        }
    }
}
