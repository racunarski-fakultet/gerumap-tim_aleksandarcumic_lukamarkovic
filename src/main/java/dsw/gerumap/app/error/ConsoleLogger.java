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
        String content = m.getContent();

        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String d = dateFormat.format(date);

        int hour = Calendar.HOUR_OF_DAY;
        int min = Calendar.MINUTE;

        System.out.println("[" + et.toString() + "] [" + d + "] [" + hour + ":" + min + "]" + m.getContent());
    }

    @Override
    public void update(Object obj) {

    }

    //treba ispisati gresku na konzolu samo
}