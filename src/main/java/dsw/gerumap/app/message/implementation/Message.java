package main.java.dsw.gerumap.app.message.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.message.EventType;

@Getter
@Setter
public class Message {

    String content;
    EventType et;

    public Message(String content, EventType et){
        this.et = et;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public EventType getEt() {
        return et;
    }
}