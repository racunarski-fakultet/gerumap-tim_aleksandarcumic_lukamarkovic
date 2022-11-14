package main.java.dsw.gerumap.app.message.implementation;

import main.java.dsw.gerumap.app.message.ErrorType;
import main.java.dsw.gerumap.app.message.EventType;

public class Message {

    String content;
    ErrorType et;

    public Message(String content, ErrorType et){
        this.content = content;
        this.et = et;

    }

    public String getContent() {
        return content;
    }

    public ErrorType getEt() {
        return et;
    }
}