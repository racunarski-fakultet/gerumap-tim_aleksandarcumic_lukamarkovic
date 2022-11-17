package main.java.dsw.gerumap.app.Observer;

import java.io.IOException;

public interface Subscriber {
    void update(Object obj) throws IOException;
}
