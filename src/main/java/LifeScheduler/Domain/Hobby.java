package LifeScheduler.Domain;

import javax.persistence.Embeddable;
import java.sql.Time;

/**
 * Created by Michael on 17/04/2015.
 */

@Embeddable
public class Hobby
{
    private String hobbyId;
    private String name;
    private int nrDaysOccupied;
    private Time timeSpentPerActivity;

    private Hobby(){}

    public Hobby(Builder builder){
        hobbyId = builder.hobbyId;
        name = builder.name;
        nrDaysOccupied = builder.nrDaysOccupied;
        timeSpentPerActivity = builder.timeSpentPerActivity;
    }

    public static class Builder{

        private String hobbyId;
        private String name;
        private int nrDaysOccupied;
        private Time timeSpentPerActivity;

        public Builder(String hobbyId,String name,int nrDaysOccupied,Time timeSpentPerActivity){
            this.hobbyId = hobbyId;
            this.name = name;
            this.nrDaysOccupied = nrDaysOccupied;
            this.timeSpentPerActivity = timeSpentPerActivity;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder nrDaysOccupied(int nrDaysOccupied){
            this.nrDaysOccupied = nrDaysOccupied;
            return this;
        }

        public Builder timeSpentPerActivity(Time timeSpentPerActivity){
            this.timeSpentPerActivity = timeSpentPerActivity;
            return this;
        }

        public Builder copy(Hobby value){
            hobbyId = value.hobbyId;
            name = value.name;
            nrDaysOccupied = value.nrDaysOccupied;
            timeSpentPerActivity = value.timeSpentPerActivity;
            return this;
        }

        public Hobby build(){
            return new Hobby(this);
        }
    }

    public String getHobbyId(){
        return hobbyId;
    }
    public String getName() {
        return name;
    }

    public int getNrDaysOccupied() {
        return nrDaysOccupied;
    }

    public Time getTimeSpentPerActivity() {
        return timeSpentPerActivity;
    }
}
