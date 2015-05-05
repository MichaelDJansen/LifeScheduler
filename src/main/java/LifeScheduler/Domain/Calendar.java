package LifeScheduler.Domain;

import javax.persistence.*;
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

    @Column(unique = true)
    String personId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    ArrayList<Task> events = new ArrayList<Task>();

    private Calendar()
    {
    }

    public Calendar(Builder builder){
        personId = builder.personId;
        events = builder.events;
    }

    public static class Builder{
        String calendarId;
        String personId;
        ArrayList<Task> events = new ArrayList<Task>();

        public Builder(String personId,ArrayList<Task> events){
            this.personId = personId;
            this.events = events;
        }

        public Builder events (ArrayList<Task> events ){
            this.events = events;
            return this;
        }

        public Builder personId(String personId)
        {
            this.personId = personId;
            return this;
        }

        public Builder calendarId(String calendarId)
        {
            this.calendarId = calendarId;
            return this;
        }


        public Builder copy(Calendar value){
            personId = value.personId;
            calendarId = value.calendarId;
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

    public String getCalendarId(){  return calendarId;    }

    public ArrayList<Task> getEvents() {
        return events;
    }
}