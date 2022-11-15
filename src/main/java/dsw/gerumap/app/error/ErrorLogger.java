package main.java.dsw.gerumap.app.error;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.message.implementation.Message;

public interface ErrorLogger extends Subscriber {
    public void log(Message m);
}
