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
    private String statId;
    private Time timeSpentTogether;
    private int nrInteractions;

    public Statistics(Builder builder){
        statId = builder.statId;
        timeSpentTogether = builder.timeSpentTogether;
        nrInteractions = builder.nrInteractions;
    }
    public static class Builder{

        private String statId;
        private Time timeSpentTogether;
        private int nrInteractions;

        public Builder(String statId,Time timeSpentTogether,int nrInteractions){
            this.statId = statId;
            this.timeSpentTogether = timeSpentTogether;
            this.nrInteractions = nrInteractions;
        }

        public Builder statId(String statId){
            this.statId = statId;
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
            statId = value.statId;
            timeSpentTogether = value.timeSpentTogether;
            nrInteractions = value.nrInteractions;
            return this;
        }
        public Statistics build(){
            return new Statistics(this);
        }
    }

    public String getStatId() {
        return statId;
    }

    public Time getTimeSpentTogether() {
        return timeSpentTogether;
    }

    public int getNrInteractions() {
        return nrInteractions;
    }
}
