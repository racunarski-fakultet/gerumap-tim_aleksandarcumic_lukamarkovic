package main.java.dsw.gerumap.app.error;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.message.implementation.Message;

import java.io.IOException;

public interface ErrorLogger extends Subscriber {
    void log(Message m);

    @Override
    default void update(Object obj) {
        Message m = (Message)obj;
        log(m);
    }
}
