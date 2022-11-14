package main.java.dsw.gerumap.app.message;

import main.java.dsw.gerumap.app.message.implementation.Message;

public interface MessageGenerator {
    public Message generate(EventType eventType);

}
