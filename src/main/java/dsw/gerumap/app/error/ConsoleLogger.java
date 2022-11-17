package main.java.dsw.gerumap.app.error;

import main.java.dsw.gerumap.app.message.ErrorType;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.implementation.Message;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConsoleLogger implements ErrorLogger{

    @Override
    public void log(Message m) {
        ErrorType et = m.getEt();

        Date date = new Date();

        System.out.println("[" + et.toString() + "] [" + date + "]" + m.getContent());
    }

    //treba ispisati gresku na konzolu samo
}