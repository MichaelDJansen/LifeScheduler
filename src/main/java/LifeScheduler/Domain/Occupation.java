package LifeScheduler.Domain;

import java.sql.Time;

/**
 * Created by Michael on 17/04/2015.
 */
public class Occupation
{
    //@Embeddable
    private String name;
    private Time start;
    private Time finish;
    private int nrDaysOccupied;
}
