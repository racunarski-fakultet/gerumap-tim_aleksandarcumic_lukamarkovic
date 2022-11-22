package main.java.dsw.gerumap.app.Observer;

import java.io.IOException;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscriber(Object obj) ;
}
