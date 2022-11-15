package main.java.dsw.gerumap.app.message;

import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.message.implementation.Message;

import java.util.ArrayList;
import java.util.List;

public interface MessageGenerator extends Publisher {
    void generate(EventType eventType);

}
