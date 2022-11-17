package main.java.dsw.gerumap.app.core;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.implementation.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface MessageGenerator extends Publisher {
    void generate(EventType eventType) throws IOException;

}
