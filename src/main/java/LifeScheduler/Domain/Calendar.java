package LifeScheduler.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class Calendar implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String calendarId;

    ArrayList<Task> events = new ArrayList<Task>();

    private Calendar (){
    }

    public Calendar(Builder builder){
        calendarId = builder.calendarId;
        events = builder.events;
    }

    public static class Builder{
        String calendarId;
        ArrayList<Task> events = new ArrayList<Task>();

        public Builder(String calendarId,ArrayList<Task> events){
            this.calendarId = calendarId;
            this.events = events;
        }

        public Builder events (ArrayList<Task> events ){
            this.events = events;
            return this;
        }
        public Builder copy(Calendar value){
            calendarId = value.calendarId;
            events = value.events;
            return this;
        }

        public Calendar build(){
            return new Calendar(this);
        }
    }

    public String getCalendarId() {
        return calendarId;
    }

    public ArrayList<Task> getEvents() {
        return events;
    }
}
