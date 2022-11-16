package main.java.dsw.gerumap.app.Observer;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscriber(Object obj);
}
