package LifeScheduler.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by Michael on 17/04/2015.
 */

@Embeddable
public class Occupation implements Serializable
{
    private String name;
    private Time start;
    private Time finish;
    private int nrDaysOccupied;

    Occupation (Builder builder){
        name = builder.name;
        start = builder.start;
        finish = builder.finish;
        nrDaysOccupied = builder.nrDaysOccupied;

    }
    public static class Builder{
        private String name;
        private Time start;
        private Time finish;
        private int nrDaysOccupied;

        public Builder(String name,Time start,Time finish,int nrDaysOccupied){
            this.name = name;
            this.start = start;
            this.finish = finish;
            this.nrDaysOccupied = nrDaysOccupied;
        }

        public Builder copy(Occupation value){
            name = value.getName();
            start = value.getStart();
            finish = value.getFinish();
            nrDaysOccupied = value.getNrDaysOccupied();
            return this;
        }

        public Occupation build(){

            return new Occupation(this);
        }
    }

    public String getName() {
        return name;
    }

    public Time getStart() {
        return start;
    }

    public Time getFinish() {
        return finish;
    }

    public int getNrDaysOccupied() {
        return nrDaysOccupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Occupation that = (Occupation) o;

        if (nrDaysOccupied != that.nrDaysOccupied) return false;
        if (finish != null ? !finish.equals(that.finish) : that.finish != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        result = 31 * result + nrDaysOccupied;
        return result;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", nrDaysOccupied=" + nrDaysOccupied +
                '}';
    }
}
