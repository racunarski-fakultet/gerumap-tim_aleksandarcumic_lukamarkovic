package main.java.dsw.gerumap.app.message.implementation;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.message.ErrorType;
import main.java.dsw.gerumap.app.message.EventType;

@Getter
@Setter
public class Message {

    String content;
    ErrorType et;

    public Message(String content, ErrorType et){
        this.et = et;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}