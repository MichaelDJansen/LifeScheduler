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
    String personId;

    ArrayList<Task> events = new ArrayList<Task>();

    private Calendar (){
    }

    public Calendar(Builder builder){
        personId = builder.personId;
        events = builder.events;
    }

    public static class Builder{
        String personId;
        ArrayList<Task> events = new ArrayList<Task>();

        public Builder(String calendarId,ArrayList<Task> events){
            this.personId = calendarId;
            this.events = events;
        }

        public Builder events (ArrayList<Task> events ){
            this.events = events;
            return this;
        }
        public Builder copy(Calendar value){
            personId = value.personId;
            events = value.events;
            return this;
        }

        public Calendar build(){
            return new Calendar(this);
        }
    }

    public String getPersonId() {
        return personId;
    }

    public ArrayList<Task> getEvents() {
        return events;
    }
}
