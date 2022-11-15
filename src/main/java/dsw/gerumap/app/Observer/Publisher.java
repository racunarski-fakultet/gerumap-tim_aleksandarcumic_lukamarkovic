package main.java.dsw.gerumap.app.Observer;

import main.java.dsw.gerumap.app.message.MessageGenerator;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    void addSubscriber(Object obj);

    void removeSubscriber(Object obj);
}
