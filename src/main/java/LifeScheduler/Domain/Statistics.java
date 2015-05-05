package LifeScheduler.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class Statistics implements Serializable
{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String personId;
    private Time timeSpentTogether;
    private int nrInteractions;

    public Statistics(Builder builder){
        personId = builder.personId;
        timeSpentTogether = builder.timeSpentTogether;
        nrInteractions = builder.nrInteractions;
    }
    public static class Builder{

        private String personId;
        private Time timeSpentTogether;
        private int nrInteractions;

        public Builder(String personId,Time timeSpentTogether,int nrInteractions){
            this.personId = personId;
            this.timeSpentTogether = timeSpentTogether;
            this.nrInteractions = nrInteractions;
        }

        public Builder personId(String personId){
            this.personId = personId;
            return this;
        }

        public Builder timeSpentTogether(Time timeSpentTogether){
            this.timeSpentTogether = timeSpentTogether;
            return this;
        }

        public Builder nrInteractions(int nrInteractions){
            this.nrInteractions = nrInteractions;
            return this;
        }

        public Builder copy(Statistics value){
            personId = value.personId;
            timeSpentTogether = value.timeSpentTogether;
            nrInteractions = value.nrInteractions;
            return this;
        }
        public Statistics build(){
            return new Statistics(this);
        }
    }

    public String getPersonId() {
        return personId;
    }

    public Time getTimeSpentTogether() {
        return timeSpentTogether;
    }

    public int getNrInteractions() {
        return nrInteractions;
    }
}
